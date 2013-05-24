package com.prompt.service;

import java.sql.SQLException;

import com.prompt.entity.ProPrompt;

public interface PromptService {
	public void addPrompt(ProPrompt pro) throws SQLException;

	public void upPrompt(ProPrompt pro) throws SQLException;

	public void delPrompt(int pro) throws SQLException;

	public ProPrompt isGetPrompt(String pro) throws SQLException;
}
