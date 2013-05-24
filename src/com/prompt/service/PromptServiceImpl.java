package com.prompt.service;

import java.sql.SQLException;

import com.prompt.dao.PromptDao;
import com.prompt.entity.ProPrompt;

public class PromptServiceImpl implements PromptService{
	private PromptDao promptDao;

	public PromptDao getPromptDao() {
		return promptDao;
	}

	public void setPromptDao(PromptDao promptDao) {
		this.promptDao = promptDao;
	}

	public void addPrompt(ProPrompt pro) throws SQLException {
		// TODO Auto-generated method stub
		promptDao.addPrompt(pro);
	}

	public void upPrompt(ProPrompt pro) throws SQLException {
		// TODO Auto-generated method stub
		promptDao.upPrompt(pro);
	}

	public void delPrompt(int pro) throws SQLException {
		// TODO Auto-generated method stub
		promptDao.delPrompt(pro);
	}

	public ProPrompt isGetPrompt(String pro) throws SQLException {
		// TODO Auto-generated method stub
		return promptDao.isGetPrompt(pro);
	}
}
