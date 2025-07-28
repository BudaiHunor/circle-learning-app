package client.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import client.model.Account;
import client.model.CircleTest;
import client.model.Language;
import client.presentation.view.TestPageGUI;
import client.services.CircleTestService;

public class TestPageController extends AbstractController {
	private TestPageGUI view;

	private int pageIndex;
	private CircleTest test;
	private double currentScore;

	// getters
	private TestPageGUI getView() {
		return this.view;
	}

	private int getPageIndex() {
		return this.pageIndex;
	}

	private CircleTest getTest() {
		return this.test;
	}

	private double getCurrentScore() {
		return this.currentScore;
	}

	// setters
	private void setView(TestPageGUI view) {
		this.view = view;
	}

	private void setPageIndex(int index) {
		this.pageIndex = index;
	}

	private void setTest(CircleTest test) {
		this.test = test;
	}

	private void setCurrentScore(double score) {
		this.currentScore = score;
	}

	// methods
	private int boolToInt(boolean condition) {
		return condition ? 1 : -1;
	}

	private double computeThisScore() {
		int index = this.getPageIndex();

		boolean check1 = this.getView().getChecked1();
		boolean check2 = this.getView().getChecked2();
		boolean check3 = this.getView().getChecked3();

		boolean correct1 = this.getTest().isQuestionNCorrect1(index - 1);
		boolean correct2 = this.getTest().isQuestionNCorrect2(index - 1);
		boolean correct3 = this.getTest().isQuestionNCorrect3(index - 1);

		int corrects = (correct1 ? 1 : 0) + (correct2 ? 1 : 0) + (correct3 ? 1 : 0);
		// make sure it's not 0, so won't divide by 0
		int nrCorrects = corrects + ((corrects == 0) ? 1 : 0);

		double point1 = check1 ? this.boolToInt(correct1) : 0.0;
		double point2 = check2 ? this.boolToInt(correct2) : 0.0;
		double point3 = check3 ? this.boolToInt(correct3) : 0.0;

		double score = Math.max(0.0, (point1 + point2 + point3 + (corrects == 0 ? 1.0 : 0.0)) / nrCorrects);
		// System.out.println("Current Score = " + score + "!\n");
		return score;
	}

	private void done() {
		int index = this.getPageIndex();
		double newScore = this.getCurrentScore() + this.computeThisScore();

		this.getView().close();
		if (index == 10) {
			TestResultController.newInstance(this.getAccount(), this.getLanguage(), newScore);
		} else {
			TestPageController.newInstance(this.getAccount(), this.getLanguage(), index + 1, this.getTest(), newScore);
		}
	}

	// newInstance methods
	public static TestPageController newInstance(Account account, Language language, int pageIndex, CircleTest test,
			double currentScore) {
		if (account == null || language == null || !(0 < pageIndex && pageIndex <= 10) || test == null
				|| !(0.0 <= currentScore && currentScore <= 10.0)) {
			return null;
		}
		return new TestPageController(account, language, pageIndex, test, currentScore);
	}

	public static TestPageController newInstance(Account account, Language language) {
		if (account == null || language == null) {
			return null;
		}
		CircleTest test = null;
		try {
			test = new CircleTestService().get();
		} catch (IOException | InterruptedException e) {
			System.err.println("Error! Server CircleTest failed to load! " + e.getMessage());
			test = CircleTest.newInstance();
		}
		return new TestPageController(account, language, 1, test, 0.0);
	}

	// constructors
	private TestPageController(Account account, Language language, int pageIndex, CircleTest test,
			double currentScore) {
		super(account, language);

		this.setPageIndex(pageIndex);
		this.setTest(test);
		this.setCurrentScore(currentScore);

		// set view
		this.setView(TestPageGUI.newInstance(language, language.translated("Test") + "! (" + pageIndex + "/10)"));

		// button next
		this.getView().getDoneButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TestPageController.this.done();
			}
		});

		// question
		this.getView().getQuestionLabel().setText(this.getTest().getQuestionNText(pageIndex - 1));

		// check box 1
		this.getView().getCheckBox1().setText(this.getTest().getQuestionNAnswer1(pageIndex - 1));

		// check box 2
		this.getView().getCheckBox2().setText(this.getTest().getQuestionNAnswer2(pageIndex - 1));

		// check box 3
		this.getView().getCheckBox3().setText(this.getTest().getQuestionNAnswer3(pageIndex - 1));

		// button next
		this.getView().getDoneButton()
				.setText(pageIndex < 10 ? (language.translated("Next") + "!") : (language.translated("Finish") + "!"));
	}
}
