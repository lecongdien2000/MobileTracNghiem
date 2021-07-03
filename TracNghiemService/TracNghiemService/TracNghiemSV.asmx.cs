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

        //lấy luôn cả ds trắc nghiệm luôn cua de da duoc duyet 
        [WebMethod]
        public DeThi getFullExamInfor(string id)
        {
            DeThi deThi = getAPartExamInfor(id);
            if (deThi != null)
            {
                List<MotLuaChon> dsTracNghiem = null;
                using (MySqlConnection conn = ConnectionDB.getConnection())
                {
                    MySqlCommand cmd = new MySqlCommand();
                    cmd.Connection = conn;
                    cmd.CommandText = "select * from cauhoi WHERE idDe like '" + id + "'";
                    using (MySqlDataReader reader = cmd.ExecuteReader())
                    {
                        dsTracNghiem = new List<MotLuaChon>();
                        while (reader.Read())
                        {
                            MotLuaChon trcnghiem = new MotLuaChon();
                            string sttCauHoi = reader.GetString("stt");
                            trcnghiem.setLabel(sttCauHoi);
                            trcnghiem.setCauHoi(reader.GetString("noiDung"));
                            trcnghiem.dsTraLoi = getDSDapAnCuaMotCauHoi(sttCauHoi, id);
                            dsTracNghiem.Add(trcnghiem);
                        }
                    }
                }
                deThi.dsMotLuaChon = dsTracNghiem;
                return deThi;
            }
            else
                return deThi;
        }
        //ok
        [WebMethod]
        private List<CauTraLoi> getDSDapAnCuaMotCauHoi(string sttCauHoi, string idDe)
        {
            List<CauTraLoi> dscautraloi = new List<CauTraLoi>();
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from dapan where idDe like '" + idDe + "' and sttCauHoi like '" + sttCauHoi + "'";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        CauTraLoi dapan = new CauTraLoi();
                        dapan.stt = Int32.Parse(reader.GetString("stt"));
                        dapan.noiDung = reader.GetString("noiDung");
                        dapan.isDapAn = reader.GetBoolean("isTrue");
                        dscautraloi.Add(dapan);
                    }
                }
            }
            return dscautraloi;
        }


        /**
        * ok (lay de theo ma de và de do phai duoc duyet ròi)
        */
        [WebMethod]
        public DeThi getAPartExamInfor(string id)
        {
            DeThi dethi = null;
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "SELECT * FROM de where id like '" + id + "' and isAccepted=true";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        dethi = new DeThi();
                        dethi.id = reader.GetString("id");
                        dethi.tieuDe = reader.GetString("name");
                        dethi.noiDung = reader.GetString("moTa");
                        dethi.lop = getLop(reader.GetInt32("lop"));
                        dethi.monHoc = getMon(reader.GetString("monHoc"));
                        dethi.isAccepted = reader.GetBoolean("isAccepted");
                    }
                }
            }

            return dethi;
        }

        //insert bảng đề 
        [WebMethod]
        public bool insertdataDeThi(string idDe, string tenDe, int lop, string maMonHoc, string noiDung, bool isAccept)
        {
            bool result = false;
            string query = "insert into de VALUES('" + idDe + "', '" + tenDe + "'," + lop + ", '" + maMonHoc + "', '" + noiDung + "'," + isAccept + ");";
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = query;
                try
                {
                    int resultaat = cmd.ExecuteNonQuery();
                    if (resultaat == 1)
                    {
                        result = true;
                    }
                    else
                    {
                        result = false;
                    }
                }
                catch (Exception)
                {
                    throw;
                }

            }
            return result;
        }

        //inserr bang cau hoi
        [WebMethod]
        public bool insertdataCauHoi(string stt, string idDe, string noiDung)
        {
            bool result = false;
            string query = "insert into cauhoi VALUES('" + stt + "', '" + idDe + "','" + noiDung + "');";
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = query;
                try
                {
                    int resultaat = cmd.ExecuteNonQuery();
                    if (resultaat == 1)
                    {
                        result = true;
                    }
                    else
                    {
                        result = false;
                    }
                }
                catch (Exception)
                {
                    throw;
                }

            }
            return result;
        }
        //insert bang dap an
        [WebMethod]
        public bool insertdataDapAn(string stt, string sttCauHoi, string idDe, string noiDung, bool isTrue)
        {
            bool result = false;
            string query = "insert into dapan VALUES('" + stt + "', '" + sttCauHoi + "','" + idDe + "','" + noiDung + "'," + isTrue + ");";
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = query;
                try
                {
                    int resultaat = cmd.ExecuteNonQuery();
                    if (resultaat == 1)
                    {
                        result = true;
                    }
                    else
                    {
                        result = false;
                    }
                }
                catch (Exception)
                {
                    throw;
                }

            }
            return result;
        }


        private Mon getMon(String id)
        {
            Mon mon = null;
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "SELECT * FROM monhoc where id like '" + id + "'";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        mon = new Mon();
                        mon.ten = reader.GetString("name");
                    }
                }
            }

            return mon;
        }

        /**
* ok
*/
        [WebMethod]
        public List<Lop> getDSLop()
        {
            List<Lop> dslop = new List<Lop>();
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "SELECT * FROM Lop";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Lop lop = new Lop();
                        lop.setLop(reader.GetInt32("lop"));
                        lop.setLabel(reader.GetString("label"));
                        dslop.Add(lop);
                    }
                }
            }

            return dslop;
        }

        [WebMethod]
        public Lop getLop(int solop)
        {
            Lop lop = null;
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
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
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "SELECT * FROM monhoc";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Mon mon = new Mon();
                        mon.ten = reader.GetString("name");
                        dsmon.Add(mon);
                    }
                }
            }
            return dsmon;
        }


        /**
         * @return(lay de đã duyet theo mon va lop da chon)
         */
        [WebMethod]
        public List<DeThi> getDeThi(string subject, int lop)
        {
            List<DeThi> arrayList = new List<DeThi>();
            using (MySqlConnection conn = ConnectionDB.getConnection())
            {
                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from de inner join monhoc on de.monHoc = monhoc.id where monhoc.name like '" + subject + "' and de.lop = " + lop + " and de.isAccepted = true";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        DeThi dethi = new DeThi();
                        dethi.id = reader.GetString(0);
                        dethi.tieuDe = reader.GetString(1);
                        dethi.lop.setLop(reader.GetInt32(2));
                        dethi.noiDung = reader.GetString(4);
                        dethi.isAccepted = reader.GetBoolean(5);
                        dethi.monHoc.ten = reader.GetString(7);
                        arrayList.Add(dethi);


                    }
                }
            }

            return arrayList;
        }
    }
}
