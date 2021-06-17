using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TracNghiemService
{
    public class DeThi
    {
        public String id;
        public String tieuDe;
        public String noiDung;
        public List<TracNghiem> dsTracNghiem;
        public Lop lop = new Lop();
        public Mon monHoc = new Mon();
        public bool isAccepted;
    }
}