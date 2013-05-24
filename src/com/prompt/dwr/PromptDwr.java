package com.prompt.dwr;

import java.sql.SQLException;

import com.prompt.entity.ProPrompt;
import com.prompt.service.PromptService;

public class PromptDwr {
	private PromptService promptService;

	public PromptService getPromptService() {
		return promptService;
	}

	public void setPromptService(PromptService promptService) {
		this.promptService = promptService;
	}

	public void addPrompt(ProPrompt pro) throws SQLException {
		promptService.addPrompt(pro);
	}

	public void upPrompt(ProPrompt pro) throws SQLException {
		promptService.upPrompt(pro);
	}

	public void delPrompt(int pro) throws SQLException {
		promptService.delPrompt(pro);
	}

	public ProPrompt isGetPrompt(String pro) throws SQLException {
		return promptService.isGetPrompt(pro);
	}
}
