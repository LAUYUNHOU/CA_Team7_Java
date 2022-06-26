package iss.sa54.team7.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iss.sa54.team7.model.Course;

@Component
public class CourseValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Course.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Course course = (Course) arg0;	
		if ((course.getCourseStartDate()!=null && course.getCourseEndDate()!=null)&&(course.getCourseStartDate().compareTo(course.getCourseEndDate()) > 0)) {
			arg1.reject("toDate", "End date should be greater than start date.");
			arg1.rejectValue("toDate", "error.dates", "to date must be > from date");
	
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "coursename", "error.coursename", "Course name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "courseStartDate", "error.courseEndDate", "courseEndDate is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "courseEndDate", "error.courseEndDate", "Course End Date is required.");
	}

}
