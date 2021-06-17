using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using MySql.Data.MySqlClient;

namespace TracNghiemService
{
    class ConnectionDB
    {
        static MySqlConnection connection = null;

        private const string SERVER = "localhost";
        private const string PORT = "3306";
        private const string USERNAME = "root";
        private const string PASSWORD = "";
        private const string DATABASE = "tracnghiemdb";
        public static MySqlConnection getConnection()
        {
            if (connection != null) return connection;
            try
            {
                connection = new MySqlConnection("datasource=" + SERVER + ";port=" + PORT + ";username=" + USERNAME + ";password=" + PASSWORD + ";database=" + DATABASE);
                connection.Open();
            }catch(Exception e){}
            return connection;
        }
    }
}
