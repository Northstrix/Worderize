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
    public partial class Form3 : Form
    {
        public static bool cont = false;
        public static string lang1 = "";
        public static string lang2 = "";
        public static string word11 = "";
        public static string word12 = "";
        public static string word21 = "";
        public static string word22 = "";
        public static string word31 = "";
        public static string word32 = "";
        public Form3()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            lang1 = l1.Text;
            lang2 = l2.Text;
            word11 = w11.Text;
            word12 = w12.Text;
            word21 = w21.Text;
            word22 = w22.Text;
            word31 = w31.Text;
            word32 = w32.Text;
            cont = true;
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            cont = false;
            this.Close();
        }
    }
}
