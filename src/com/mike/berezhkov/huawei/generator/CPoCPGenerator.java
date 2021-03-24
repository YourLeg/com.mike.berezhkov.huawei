package com.mike.berezhkov.huawei.generator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.mike.berezhkov.huawei.cPoCP.Course;
import com.mike.berezhkov.huawei.cPoCP.CourseGrade;
import com.mike.berezhkov.huawei.cPoCP.Score;
import com.mike.berezhkov.huawei.cPoCP.Student;

public class CPoCPGenerator extends AbstractGenerator{

	@Override
	public void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		Map<Course, Set<Student>> courseToStudent = new HashMap<>();
		TreeIterator<EObject> contentIterator = input.getAllContents();
		while (contentIterator.hasNext()) {
			EObject content = (EObject) contentIterator.next();
			if(content instanceof Score) {
				Score score = (Score)content;
				Student student = score.getStudent();
				for(CourseGrade courseGrade : score.getCourseGrade()) {
					Course course = courseGrade.getCourse();
					courseToStudent.computeIfAbsent(course, k -> new HashSet<Student>());
					courseToStudent.get(course).add(student);
				}
			}
		}
		StringBuilder toWrite = new StringBuilder("<?xml version = \"1.0\" encoding = \"UTF-8\"?>");
		toWrite.append("\n<courses>");
		for(Entry<Course, Set<Student>> ent : courseToStudent.entrySet()) {
			toWrite.append("\n\t<course>")
			.append(ent.getKey().getName());
			for(Student student : ent.getValue()) {
				toWrite.append("\n\t\t<student>")
				.append(student.getName())
				.append("</student>");
			}
			toWrite.append("\n\t</course>");
		}
		toWrite.append("\n</courses>");
		fsa.generateFile("autogen.xml", toWrite);
	}

}
