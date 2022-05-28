using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MongoDB.Bson;
using MongoDB.Driver;
using System.Configuration;
using Worderize;

namespace Worderize
{
    public partial class Form8 : Form
    {
        public static String t_rem;
        public static bool rmrec = false;
        public static String[] ext_id;
        public Form8()
        {
            InitializeComponent();
            var wrds = Form1.database.GetCollection<BsonDocument>("Words");
            var documents = wrds.Find(new BsonDocument()).ToList();
            int i = 0;
            foreach (BsonDocument doc in documents)
            {
                i++;
            }
            int j = i;
            ext_id = new String[i];
            i = 0;
            foreach (BsonDocument doc in documents)
            {
                ext_id[i] = doc["ID"].ToString();
                if (doc["Type"].ToString() == "32" || doc["Type"].ToString() == "33" || doc["Type"].ToString() == "34")
                {
                    comboBox1.Items.Add(doc["word11"].ToString() + ", " + doc["word21"].ToString() + ", " + doc["word31"].ToString());
                }
                if (doc["Type"].ToString() == "43" || doc["Type"].ToString() == "44")
                {
                    comboBox1.Items.Add(doc["word11"].ToString() + ", " + doc["word21"].ToString() + ", " + doc["word31"].ToString() + ", " + doc["word41"].ToString());
                }
                if (doc["Type"].ToString() == "54")
                {
                    comboBox1.Items.Add(doc["word11"].ToString() + ", " + doc["word21"].ToString() + ", " + doc["word31"].ToString() + ", " + doc["word41"].ToString() + ", " + doc["word51"].ToString());
                }
                i++;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            rmrec = true;
            t_rem = ext_id[comboBox1.SelectedIndex];
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            rmrec = false;
            this.Close();
        }
    }
}
