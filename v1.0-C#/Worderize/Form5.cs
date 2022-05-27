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
    public partial class Form5 : Form
    {
        public static bool cont = false;
        public static string lang1 = "";
        public static string lang2 = "";
        public static string lang3 = "";
        public static string word11 = "";
        public static string word12 = "";
        public static string word13 = "";
        public static string word21 = "";
        public static string word22 = "";
        public static string word23 = "";
        public static string word31 = "";
        public static string word32 = "";
        public static string word33 = "";
        public static string word41 = "";
        public static string word42 = "";
        public static string word43 = "";
        public Form5()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            lang1 = l1.Text;
            lang2 = l2.Text;
            lang3 = l3.Text;
            word11 = w11.Text;
            word12 = w12.Text;
            word13 = w13.Text;
            word21 = w21.Text;
            word22 = w22.Text;
            word23 = w23.Text;
            word31 = w31.Text;
            word32 = w32.Text;
            word33 = w33.Text;
            word41 = w41.Text;
            word42 = w42.Text;
            word43 = w43.Text;
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
