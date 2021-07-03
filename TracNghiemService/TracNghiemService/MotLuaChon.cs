using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TracNghiemService
{
    public class MotLuaChon : TracNghiem
    {
        public List<CauTraLoi> dsTraLoi;
        public MotLuaChon()
        {
            this.label = "";
            this.cauHoi = "";
            this.dsTraLoi = new List<CauTraLoi>();
        }
        public string getCauHoi()
        {
            return this.cauHoi;
        }

        public void setCauHoi(string cauhoi)
        {
            this.cauHoi = cauhoi;
        }

        public string getLabel()
        {
            return this.label;
        }

        public void setLabel(string label)
        {
            this.label = label;
        }

    }
}