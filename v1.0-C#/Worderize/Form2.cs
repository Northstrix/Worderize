using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Worderize
{
    public partial class Form2 : Form
    {
        public static bool addrec = false;
        public static int r_type = 0;
        public Form2()
        {
            InitializeComponent();
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            r_type = 32;
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            r_type = 33;
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {
            r_type = 43;
        }

        private void radioButton4_CheckedChanged(object sender, EventArgs e)
        {
            r_type = 44;
        }

        private void radioButton5_CheckedChanged(object sender, EventArgs e)
        {
            r_type = 54;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            addrec = true;
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            addrec = false;
            this.Close();
        }
    }
}
