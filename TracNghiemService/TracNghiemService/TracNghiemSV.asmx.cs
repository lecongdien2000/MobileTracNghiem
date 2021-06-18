using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace TracNghiemService
{
    /// <summary>
    /// Summary description for TracNghiemSV
    /// </summary>
    [WebService(Namespace = "http://tracnghiemwebservice.com/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class TracNghiemSV : System.Web.Services.WebService
    {

      
        [WebMethod]
        public DeThi getFullExamInfor(string id)
        {
            //TODO
            return null;
        }
        /**
        * 
        */
        [WebMethod]
        public DeThi getAPartExamInfor(string id)
        {
            //TODO
            return null;
        }
        /**
        * 
        */
        [WebMethod]
        public List<Lop> getDSLop()
        {
            List<Lop> dslop = new List<Lop>();
            MySqlCommand cmd = new MySqlCommand();
            cmd.Connection = ConnectionDB.getConnection();
            cmd.CommandText = "SELECT * FROM Lop";
            MySqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Lop lop = new Lop();
                lop.setLop(reader.GetInt32("lop"));
                lop.setLabel(reader.GetString("label"));
                dslop.Add(lop);
            }
            reader.Close();
            ConnectionDB.close();
            return dslop;
        }

        [WebMethod]
        public Lop getLop(int solop)
        {
            Lop lop = null;
            using(MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = ConnectionDB.getConnection();
                cmd.CommandText = "SELECT * FROM Lop where lop = " + solop;
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        lop = new Lop();
                        lop.setLop(reader.GetInt32("lop"));
                        lop.setLabel(reader.GetString("label"));
                    }
                }
            }
            
            return lop;
        }

        /**
        * 
        */
        [WebMethod]
        public List<Mon> getDSMon()
        {
            List<Mon> dsmon = new List<Mon>();
            //TODO
            return dsmon;
        }
        /**
        * 
        */
        [WebMethod]
        public void insertDeThi(DeThi dethi)
        {
            // TODO implement here
        }

        /**
         * @return
         */
        [WebMethod]
        public List<DeThi> getDeThi(string subject, int lop)
        {
            List<DeThi> arrayList = new List<DeThi>();
            //TODO
            return arrayList;
        }

      
        /**
         * @param idDe 
         * @return
         */
        [WebMethod]
        public DeThi getExamInfor(string idDe)
        {
            // TODO implement here
            return null;
        }

        /**
         * @param isAccepted 
         * @param id
         */
        [WebMethod]
        public void processExam(bool isAccepted, string id)
        {
            // TODO implement here
        }

    }
}
