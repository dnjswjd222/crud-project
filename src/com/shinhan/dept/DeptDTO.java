package com.shinhan.dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptDTO {
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
}
