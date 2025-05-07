package com.shinhan.job;

import com.shinhan.common.CommonInterface;

public class JobController implements CommonInterface{

	@Override
	public void execute() {
		System.out.println("job controller 입니다.");
	}

	
}
