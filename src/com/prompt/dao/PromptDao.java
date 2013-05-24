package com.prompt.dao;

import java.sql.SQLException;

import com.prompt.entity.ProPrompt;

public interface PromptDao {
	public void addPrompt(ProPrompt pro) throws SQLException;

	public void upPrompt(ProPrompt pro) throws SQLException;

	public void delPrompt(int pro) throws SQLException;

	public ProPrompt isGetPrompt(String pro) throws SQLException;
}
