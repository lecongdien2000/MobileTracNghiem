using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TracNghiemService
{
    public class Lop
    {
        public int lop;

        public String label;

        public void setLop(int lop)
        {
            this.lop = lop;
        }

        public void setLabel(String label)
        {
            this.label = label;
        }
    }
}