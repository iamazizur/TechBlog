package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import org.apache.tomcat.util.json.JSONParser;

import com.entities.Category;
import com.google.gson.Gson;
import com.helper.ConnectionProvider;


public class CategoryDao {
	private Connection connection;

	public CategoryDao(Connection connection) {
		this.connection = connection;
	}
//	public static void main(String[] args) {
//		Connection connection = ConnectionProvider.getConnection();
//		CategoryDao dao = new CategoryDao(connection);
//		ArrayList<Category> response = dao.getCategories();
//		System.out.println(response);
//		Gson gson = new Gson();
//		String json = gson.toJson(response);
//		System.out.println(json);
//	}

	public ArrayList<Category> getCategories() {
		ArrayList<Category> result = new ArrayList<>();
		try {
			ResultSet resultSet = getAllRows();
			while(resultSet.next()) {
				int cid = resultSet.getInt("cid");
				String title =  resultSet.getString("title");
				String description =  resultSet.getString("description");
				Category category = new Category(cid, title, description);
				result.add(category);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private ResultSet getAllRows() {
		try {
			String query = "SELECT * FROM categories";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet set = preparedStatement.executeQuery();
			return set;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
