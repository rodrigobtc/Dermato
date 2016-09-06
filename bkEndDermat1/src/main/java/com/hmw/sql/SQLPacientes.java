package com.hmw.sql;

public class SQLPacientes {
	public static String getPacientes(String nome) {
		StringBuffer sb = new StringBuffer();
		sb.append("select id, nome from paciente where nome ilike '%" + nome + "%' order by nome");
		return sb.toString();
	}

}
