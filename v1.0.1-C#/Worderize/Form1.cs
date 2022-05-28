using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MongoDB.Bson;
using MongoDB.Driver;
using System.Configuration;
using System.Data;

namespace Worderize
{
    public partial class Form1 : Form
    {
        public static string connectionString;
        public static MongoClient client;
        public static IMongoDatabase database;
        public static List<string> listed_id = new List<string>();
        public static int cl_num;
        public Form1()
        {
            InitializeComponent();
            try
            {
                connectionString = "mongodb://localhost:27017";
                client = new MongoClient(connectionString);
                database = client.GetDatabase("Worderize");
            }
            catch (Exception ex)
            {
            }
            disp_recs();
        }

        private void disp_recs()
        {
            listed_id.Clear();
            Listed_recs.Items.Clear();
            var wrds = database.GetCollection<BsonDocument>("Words");
            var documents = wrds.Find(new BsonDocument()).ToList();
            int i = 0;
            foreach (BsonDocument doc in documents)
            {
                i++;
            }
            int j = i;
            i = 0;
            foreach (BsonDocument doc in documents)
            {
                listed_id.Add(doc["ID"].ToString());
                if (doc["Type"].ToString() == "32" || doc["Type"].ToString() == "33" || doc["Type"].ToString() == "34")
                {
                    Listed_recs.Items.Add(doc["word11"].ToString() + ", " + doc["word21"].ToString() + ", " + doc["word31"].ToString());
                }
                if (doc["Type"].ToString() == "43" || doc["Type"].ToString() == "44")
                {
                    Listed_recs.Items.Add(doc["word11"].ToString() + ", " + doc["word21"].ToString() + ", " + doc["word31"].ToString() + ", " + doc["word41"].ToString());
                }
                if (doc["Type"].ToString() == "54")
                {
                    Listed_recs.Items.Add(doc["word11"].ToString() + ", " + doc["word21"].ToString() + ", " + doc["word31"].ToString() + ", " + doc["word41"].ToString() + ", " + doc["word51"].ToString());
                }
                i++;
            }
        }

        private String gen_rnd_ID()
        {
            Random rd = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 128; i++)
            {
                sb.Append(Convert.ToChar(rd.Next(32, 120)));
            }
            return sb.ToString();
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                var rcrd = database.GetCollection<BsonDocument>("Words");
                var filter = Builders<BsonDocument>.Filter.Eq("ID", listed_id[Listed_recs.SelectedIndex]);
                var doc = rcrd.Find(filter).FirstOrDefault();
                Color frc = new Color();
                frc = Color.FromArgb(238, 238, 238);
                Color bgc = new Color();
                bgc = Color.FromArgb(79, 164, 236);
                dataGridView1.EnableHeadersVisualStyles = false;
                dataGridView1.ColumnHeadersDefaultCellStyle.BackColor = bgc;
                dataGridView1.ColumnHeadersDefaultCellStyle.ForeColor = frc;
                dataGridView1.ForeColor = frc;
                dataGridView1.BackgroundColor = bgc;
                dataGridView1.DefaultCellStyle.Font = new Font("Segoe UI Semibold", 14);
                dataGridView1.RowsDefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter;
                dataGridView1.ColumnHeadersDefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter;
                if (doc["Type"].ToString() == "32")
                {
                    cl_num = 2;
                    dataGridView1.Rows.Clear();
                    dataGridView1.Columns.Clear();
                    dataGridView1.Columns.Add("Text", doc["lang1"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang2"].ToString());
                    dataGridView1.Rows.Add(new object[] { doc["word11"].ToString(), doc["word12"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word21"].ToString(), doc["word22"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word31"].ToString(), doc["word32"].ToString() });
                    for (int i = 0; i < 3; i++)
                        dataGridView1.Rows[i].Height = 40;

                    for (int i = 0; i < 3; i++)
                    {
                        for (int j = 0; j < 2; j++)
                            dataGridView1.Rows[i].Cells[j].Style.BackColor = bgc;
                    }
                }
                if (doc["Type"].ToString() == "33")
                {
                    cl_num = 3;
                    dataGridView1.Rows.Clear();
                    dataGridView1.Columns.Clear();
                    dataGridView1.Columns.Add("Text", doc["lang1"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang2"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang3"].ToString());
                    dataGridView1.Rows.Add(new object[] { doc["word11"].ToString(), doc["word12"].ToString(), doc["word13"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word21"].ToString(), doc["word22"].ToString(), doc["word23"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word31"].ToString(), doc["word32"].ToString(), doc["word33"].ToString() });
                    for (int i = 0; i < 3; i++)
                        dataGridView1.Rows[i].Height = 40;

                    for (int i = 0; i < 3; i++)
                    {
                        for (int j = 0; j < 3; j++)
                            dataGridView1.Rows[i].Cells[j].Style.BackColor = bgc;
                    }
                }
                if (doc["Type"].ToString() == "43")
                {
                    cl_num = 3;
                    dataGridView1.Rows.Clear();
                    dataGridView1.Columns.Clear();
                    dataGridView1.Columns.Add("Text", doc["lang1"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang2"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang3"].ToString());
                    dataGridView1.Rows.Add(new object[] { doc["word11"].ToString(), doc["word12"].ToString(), doc["word13"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word21"].ToString(), doc["word22"].ToString(), doc["word23"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word31"].ToString(), doc["word32"].ToString(), doc["word33"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word41"].ToString(), doc["word42"].ToString(), doc["word43"].ToString() });
                    for (int i = 0; i < 4; i++)
                        dataGridView1.Rows[i].Height = 40;

                    for (int i = 0; i < 4; i++)
                    {
                        for (int j = 0; j < 3; j++)
                            dataGridView1.Rows[i].Cells[j].Style.BackColor = bgc;
                    }
                }
                if (doc["Type"].ToString() == "44")
                {
                    cl_num = 4;
                    dataGridView1.Rows.Clear();
                    dataGridView1.Columns.Clear();
                    dataGridView1.Columns.Add("Text", doc["lang1"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang2"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang3"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang4"].ToString());
                    dataGridView1.Rows.Add(new object[] { doc["word11"].ToString(), doc["word12"].ToString(), doc["word13"].ToString(), doc["word14"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word21"].ToString(), doc["word22"].ToString(), doc["word23"].ToString(), doc["word24"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word31"].ToString(), doc["word32"].ToString(), doc["word33"].ToString(), doc["word34"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word41"].ToString(), doc["word42"].ToString(), doc["word43"].ToString(), doc["word44"].ToString() });
                    for (int i = 0; i < 4; i++)
                        dataGridView1.Rows[i].Height = 40;

                    for (int i = 0; i < 4; i++)
                    {
                        for (int j = 0; j < 4; j++)
                            dataGridView1.Rows[i].Cells[j].Style.BackColor = bgc;
                    }
                }
                if (doc["Type"].ToString() == "54")
                {
                    cl_num = 4;
                    dataGridView1.Rows.Clear();
                    dataGridView1.Columns.Clear();
                    dataGridView1.Columns.Add("Text", doc["lang1"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang2"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang3"].ToString());
                    dataGridView1.Columns.Add("Text", doc["lang4"].ToString());
                    dataGridView1.Rows.Add(new object[] { doc["word11"].ToString(), doc["word12"].ToString(), doc["word13"].ToString(), doc["word14"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word21"].ToString(), doc["word22"].ToString(), doc["word23"].ToString(), doc["word24"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word31"].ToString(), doc["word32"].ToString(), doc["word33"].ToString(), doc["word34"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word41"].ToString(), doc["word42"].ToString(), doc["word43"].ToString(), doc["word44"].ToString() });
                    dataGridView1.Rows.Add(new object[] { doc["word51"].ToString(), doc["word52"].ToString(), doc["word53"].ToString(), doc["word54"].ToString() });
                    for (int i = 0; i < 5; i++)
                        dataGridView1.Rows[i].Height = 40;

                    for (int i = 0; i < 5; i++)
                    {
                        for (int j = 0; j < 4; j++)
                            dataGridView1.Rows[i].Cells[j].Style.BackColor = bgc;
                    }
                }
            }
            catch (Exception ex)
            {
            }
            res_grid();
        }

        private void res_grid()
        {
            if (cl_num > 0) {
                int wd = (((this.Size.Width) - this.splitContainer1.SplitterDistance) - 102) / cl_num;
                for (int i = 0; i < cl_num; i++)
                    dataGridView1.Columns[i].Width = wd;
                dataGridView1.Refresh();
            }
        }

        private void Form1_SizeChanged(object sender, EventArgs e)
        {
            res_grid();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.ShowDialog();
            if (Form2.addrec == true)
            {
                if (Form2.r_type == 32)
                {
                    Form3 f3 = new Form3();
                    f3.Text = "Add record";
                    f3.ShowDialog();
                    if (Form3.cont == true)
                    {
                        var Collec = database.GetCollection<BsonDocument>("Words");
                        String id = gen_rnd_ID();
                        var documnt = new BsonDocument
                        {
                            {"ID", id},
                            {"Type", 32},
                            {"lang1", Form3.lang1},
                            {"lang2", Form3.lang2},
                            {"word11", Form3.word11},
                            {"word12", Form3.word12},
                            {"word21", Form3.word21},
                            {"word22", Form3.word22},
                            {"word31", Form3.word31},
                            {"word32", Form3.word32}
                        };
                        Collec.InsertOneAsync(documnt);
                    }
                }
                if (Form2.r_type == 33)
                {
                    Form4 f4 = new Form4();
                    f4.Text = "Add record";
                    f4.ShowDialog();
                    if (Form4.cont == true)
                    {
                        var Collec = database.GetCollection<BsonDocument>("Words");
                        String id = gen_rnd_ID();
                        var documnt = new BsonDocument
                        {
                            {"ID", id},
                            {"Type", 33},
                            {"lang1", Form4.lang1},
                            {"lang2", Form4.lang2},
                            {"lang3", Form4.lang3},
                            {"word11", Form4.word11},
                            {"word12", Form4.word12},
                            {"word13", Form4.word13},
                            {"word21", Form4.word21},
                            {"word22", Form4.word22},
                            {"word23", Form4.word23},
                            {"word31", Form4.word31},
                            {"word32", Form4.word32},
                            {"word33", Form4.word33}
                        };
                        Collec.InsertOneAsync(documnt);
                    }
                }
                if (Form2.r_type == 43)
                {
                    Form5 f5 = new Form5();
                    f5.Text = "Add record";
                    f5.ShowDialog();
                    if (Form5.cont == true)
                    {
                        var Collec = database.GetCollection<BsonDocument>("Words");
                        String id = gen_rnd_ID();
                        var documnt = new BsonDocument
                        {
                            {"ID", id},
                            {"Type", 43},
                            {"lang1", Form5.lang1},
                            {"lang2", Form5.lang2},
                            {"lang3", Form5.lang3},
                            {"word11", Form5.word11},
                            {"word12", Form5.word12},
                            {"word13", Form5.word13},
                            {"word21", Form5.word21},
                            {"word22", Form5.word22},
                            {"word23", Form5.word23},
                            {"word31", Form5.word31},
                            {"word32", Form5.word32},
                            {"word33", Form5.word33},
                            {"word41", Form5.word41},
                            {"word42", Form5.word42},
                            {"word43", Form5.word43}
                        };
                        Collec.InsertOneAsync(documnt);
                    }
                }
                if (Form2.r_type == 44)
                {
                    Form6 f6 = new Form6();
                    f6.Text = "Add record";
                    f6.ShowDialog();
                    if (Form6.cont == true)
                    {
                        var Collec = database.GetCollection<BsonDocument>("Words");
                        String id = gen_rnd_ID();
                        var documnt = new BsonDocument
                        {
                            {"ID", id},
                            {"Type", 44},
                            {"lang1", Form6.lang1},
                            {"lang2", Form6.lang2},
                            {"lang3", Form6.lang3},
                            {"lang4", Form6.lang4},
                            {"word11", Form6.word11},
                            {"word12", Form6.word12},
                            {"word13", Form6.word13},
                            {"word14", Form6.word14},
                            {"word21", Form6.word21},
                            {"word22", Form6.word22},
                            {"word23", Form6.word23},
                            {"word24", Form6.word24},
                            {"word31", Form6.word31},
                            {"word32", Form6.word32},
                            {"word33", Form6.word33},
                            {"word34", Form6.word34},
                            {"word41", Form6.word41},
                            {"word42", Form6.word42},
                            {"word43", Form6.word43},
                            {"word44", Form6.word44}
                        };
                        Collec.InsertOneAsync(documnt);
                    }
                }
                if (Form2.r_type == 54)
                {
                    Form7 f7 = new Form7();
                    f7.Text = "Add record";
                    f7.ShowDialog();
                    if (Form7.cont == true)
                    {
                        var Collec = database.GetCollection<BsonDocument>("Words");
                        String id = gen_rnd_ID();
                        var documnt = new BsonDocument
                        {
                            {"ID", id},
                            {"Type", 54},
                            {"lang1", Form7.lang1},
                            {"lang2", Form7.lang2},
                            {"lang3", Form7.lang3},
                            {"lang4", Form7.lang4},
                            {"word11", Form7.word11},
                            {"word12", Form7.word12},
                            {"word13", Form7.word13},
                            {"word14", Form7.word14},
                            {"word21", Form7.word21},
                            {"word22", Form7.word22},
                            {"word23", Form7.word23},
                            {"word24", Form7.word24},
                            {"word31", Form7.word31},
                            {"word32", Form7.word32},
                            {"word33", Form7.word33},
                            {"word34", Form7.word34},
                            {"word41", Form7.word41},
                            {"word42", Form7.word42},
                            {"word43", Form7.word43},
                            {"word44", Form7.word44},
                            {"word51", Form7.word51},
                            {"word52", Form7.word52},
                            {"word53", Form7.word53},
                            {"word54", Form7.word54}
                        };
                        Collec.InsertOneAsync(documnt);
                    }
                }
            }
            disp_recs();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            Form8 f8 = new Form8();
            f8.ShowDialog();
            if (Form8.rmrec == true)
            {
                var collection = database.GetCollection<BsonDocument>("Words");
                var Deleteone = collection.DeleteOneAsync(Builders<BsonDocument>.Filter.Eq("ID", Form8.t_rem));
            }
            disp_recs();
        }

        private void splitContainer1_SplitterMoved(object sender, SplitterEventArgs e)
        {
            res_grid();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form8 f8 = new Form8();
            f8.Text = "Edit record";
            f8.label1.Text = " Choose record to edit";
            f8.button1.Text = "Choose";
            f8.ShowDialog();
            if (Form8.rmrec == true)
            {
                if (get_value(Form8.t_rem, "Type") == "32")
                {
                    Form3 f3 = new Form3();
                    f3.Text = "Edit record";
                    f3.button1.Text = "Save";
                    f3.l1.Text = get_value(Form8.t_rem, "lang1");
                    f3.l2.Text = get_value(Form8.t_rem, "lang2");
                    f3.w11.Text = get_value(Form8.t_rem, "word11");
                    f3.w12.Text = get_value(Form8.t_rem, "word12");
                    f3.w21.Text = get_value(Form8.t_rem, "word21");
                    f3.w22.Text = get_value(Form8.t_rem, "word22");
                    f3.w31.Text = get_value(Form8.t_rem, "word31");
                    f3.w32.Text = get_value(Form8.t_rem, "word32");
                    f3.ShowDialog();
                    if (Form3.cont == true)
                    {
                        modify("lang1", Form3.lang1, Form8.t_rem);
                        modify("lang2", Form3.lang2, Form8.t_rem);
                        modify("word11", Form3.word11, Form8.t_rem);
                        modify("word12", Form3.word12, Form8.t_rem);
                        modify("word21", Form3.word21, Form8.t_rem);
                        modify("word22", Form3.word22, Form8.t_rem);
                        modify("word31", Form3.word31, Form8.t_rem);
                        modify("word32", Form3.word32, Form8.t_rem);
                    }
                }
                if (get_value(Form8.t_rem, "Type") == "33")
                {
                    Form4 f4 = new Form4();
                    f4.Text = "Edit record";
                    f4.button1.Text = "Save";
                    f4.l1.Text = get_value(Form8.t_rem, "lang1");
                    f4.l2.Text = get_value(Form8.t_rem, "lang2");
                    f4.l3.Text = get_value(Form8.t_rem, "lang3");
                    f4.w11.Text = get_value(Form8.t_rem, "word11");
                    f4.w12.Text = get_value(Form8.t_rem, "word12");
                    f4.w13.Text = get_value(Form8.t_rem, "word13");
                    f4.w21.Text = get_value(Form8.t_rem, "word21");
                    f4.w22.Text = get_value(Form8.t_rem, "word22");
                    f4.w23.Text = get_value(Form8.t_rem, "word23");
                    f4.w31.Text = get_value(Form8.t_rem, "word31");
                    f4.w32.Text = get_value(Form8.t_rem, "word32");
                    f4.w33.Text = get_value(Form8.t_rem, "word33");
                    f4.ShowDialog();
                    if (Form4.cont == true)
                    {
                        modify("lang1", Form4.lang1, Form8.t_rem);
                        modify("lang2", Form4.lang2, Form8.t_rem);
                        modify("lang3", Form4.lang3, Form8.t_rem);
                        modify("word11", Form4.word11, Form8.t_rem);
                        modify("word12", Form4.word12, Form8.t_rem);
                        modify("word13", Form4.word13, Form8.t_rem);
                        modify("word21", Form4.word21, Form8.t_rem);
                        modify("word22", Form4.word22, Form8.t_rem);
                        modify("word23", Form4.word23, Form8.t_rem);
                        modify("word31", Form4.word31, Form8.t_rem);
                        modify("word32", Form4.word32, Form8.t_rem);
                        modify("word33", Form4.word33, Form8.t_rem);
                    }
                }
                if (get_value(Form8.t_rem, "Type") == "43")
                {
                    Form5 f5 = new Form5();
                    f5.Text = "Edit record";
                    f5.button1.Text = "Save";
                    f5.l1.Text = get_value(Form8.t_rem, "lang1");
                    f5.l2.Text = get_value(Form8.t_rem, "lang2");
                    f5.l3.Text = get_value(Form8.t_rem, "lang3");
                    f5.w11.Text = get_value(Form8.t_rem, "word11");
                    f5.w12.Text = get_value(Form8.t_rem, "word12");
                    f5.w13.Text = get_value(Form8.t_rem, "word13");
                    f5.w21.Text = get_value(Form8.t_rem, "word21");
                    f5.w22.Text = get_value(Form8.t_rem, "word22");
                    f5.w23.Text = get_value(Form8.t_rem, "word23");
                    f5.w31.Text = get_value(Form8.t_rem, "word31");
                    f5.w32.Text = get_value(Form8.t_rem, "word32");
                    f5.w33.Text = get_value(Form8.t_rem, "word33");
                    f5.w41.Text = get_value(Form8.t_rem, "word41");
                    f5.w42.Text = get_value(Form8.t_rem, "word42");
                    f5.w43.Text = get_value(Form8.t_rem, "word43");
                    f5.ShowDialog();
                    if (Form5.cont == true)
                    {
                        modify("lang1", Form5.lang1, Form8.t_rem);
                        modify("lang2", Form5.lang2, Form8.t_rem);
                        modify("lang3", Form5.lang3, Form8.t_rem);
                        modify("word11", Form5.word11, Form8.t_rem);
                        modify("word12", Form5.word12, Form8.t_rem);
                        modify("word13", Form5.word13, Form8.t_rem);
                        modify("word21", Form5.word21, Form8.t_rem);
                        modify("word22", Form5.word22, Form8.t_rem);
                        modify("word23", Form5.word23, Form8.t_rem);
                        modify("word31", Form5.word31, Form8.t_rem);
                        modify("word32", Form5.word32, Form8.t_rem);
                        modify("word33", Form5.word33, Form8.t_rem);
                        modify("word41", Form5.word41, Form8.t_rem);
                        modify("word42", Form5.word42, Form8.t_rem);
                        modify("word43", Form5.word43, Form8.t_rem);
                    }
                }
                if (get_value(Form8.t_rem, "Type") == "44")
                {
                    Form6 f6 = new Form6();
                    f6.Text = "Edit record";
                    f6.button1.Text = "Save";
                    f6.l1.Text = get_value(Form8.t_rem, "lang1");
                    f6.l2.Text = get_value(Form8.t_rem, "lang2");
                    f6.l3.Text = get_value(Form8.t_rem, "lang3");
                    f6.l4.Text = get_value(Form8.t_rem, "lang4");
                    f6.w11.Text = get_value(Form8.t_rem, "word11");
                    f6.w12.Text = get_value(Form8.t_rem, "word12");
                    f6.w13.Text = get_value(Form8.t_rem, "word13");
                    f6.w14.Text = get_value(Form8.t_rem, "word14");
                    f6.w21.Text = get_value(Form8.t_rem, "word21");
                    f6.w22.Text = get_value(Form8.t_rem, "word22");
                    f6.w23.Text = get_value(Form8.t_rem, "word23");
                    f6.w24.Text = get_value(Form8.t_rem, "word24");
                    f6.w31.Text = get_value(Form8.t_rem, "word31");
                    f6.w32.Text = get_value(Form8.t_rem, "word32");
                    f6.w33.Text = get_value(Form8.t_rem, "word33");
                    f6.w34.Text = get_value(Form8.t_rem, "word34");
                    f6.w41.Text = get_value(Form8.t_rem, "word41");
                    f6.w42.Text = get_value(Form8.t_rem, "word42");
                    f6.w43.Text = get_value(Form8.t_rem, "word43");
                    f6.w44.Text = get_value(Form8.t_rem, "word44");
                    f6.ShowDialog();
                    if (Form6.cont == true)
                    {
                        modify("lang1", Form6.lang1, Form8.t_rem);
                        modify("lang2", Form6.lang2, Form8.t_rem);
                        modify("lang3", Form6.lang3, Form8.t_rem);
                        modify("lang4", Form6.lang4, Form8.t_rem);
                        modify("word11", Form6.word11, Form8.t_rem);
                        modify("word12", Form6.word12, Form8.t_rem);
                        modify("word13", Form6.word13, Form8.t_rem);
                        modify("word14", Form6.word14, Form8.t_rem);
                        modify("word21", Form6.word21, Form8.t_rem);
                        modify("word22", Form6.word22, Form8.t_rem);
                        modify("word23", Form6.word23, Form8.t_rem);
                        modify("word24", Form6.word24, Form8.t_rem);
                        modify("word31", Form6.word31, Form8.t_rem);
                        modify("word32", Form6.word32, Form8.t_rem);
                        modify("word33", Form6.word33, Form8.t_rem);
                        modify("word34", Form6.word34, Form8.t_rem);
                        modify("word41", Form6.word41, Form8.t_rem);
                        modify("word42", Form6.word42, Form8.t_rem);
                        modify("word43", Form6.word43, Form8.t_rem);
                        modify("word44", Form6.word44, Form8.t_rem);
                    }
                }
                if (get_value(Form8.t_rem, "Type") == "54")
                {
                    Form7 f7 = new Form7();
                    f7.Text = "Edit record";
                    f7.button1.Text = "Save";
                    f7.l1.Text = get_value(Form8.t_rem, "lang1");
                    f7.l2.Text = get_value(Form8.t_rem, "lang2");
                    f7.l3.Text = get_value(Form8.t_rem, "lang3");
                    f7.l4.Text = get_value(Form8.t_rem, "lang4");
                    f7.w11.Text = get_value(Form8.t_rem, "word11");
                    f7.w12.Text = get_value(Form8.t_rem, "word12");
                    f7.w13.Text = get_value(Form8.t_rem, "word13");
                    f7.w14.Text = get_value(Form8.t_rem, "word14");
                    f7.w21.Text = get_value(Form8.t_rem, "word21");
                    f7.w22.Text = get_value(Form8.t_rem, "word22");
                    f7.w23.Text = get_value(Form8.t_rem, "word23");
                    f7.w24.Text = get_value(Form8.t_rem, "word24");
                    f7.w31.Text = get_value(Form8.t_rem, "word31");
                    f7.w32.Text = get_value(Form8.t_rem, "word32");
                    f7.w33.Text = get_value(Form8.t_rem, "word33");
                    f7.w34.Text = get_value(Form8.t_rem, "word34");
                    f7.w41.Text = get_value(Form8.t_rem, "word41");
                    f7.w42.Text = get_value(Form8.t_rem, "word42");
                    f7.w43.Text = get_value(Form8.t_rem, "word43");
                    f7.w44.Text = get_value(Form8.t_rem, "word44");
                    f7.w51.Text = get_value(Form8.t_rem, "word51");
                    f7.w52.Text = get_value(Form8.t_rem, "word52");
                    f7.w53.Text = get_value(Form8.t_rem, "word53");
                    f7.w54.Text = get_value(Form8.t_rem, "word54");
                    f7.ShowDialog();
                    if (Form7.cont == true)
                    {
                        modify("lang1", Form7.lang1, Form8.t_rem);
                        modify("lang2", Form7.lang2, Form8.t_rem);
                        modify("lang3", Form7.lang3, Form8.t_rem);
                        modify("lang4", Form7.lang4, Form8.t_rem);
                        modify("word11", Form7.word11, Form8.t_rem);
                        modify("word12", Form7.word12, Form8.t_rem);
                        modify("word13", Form7.word13, Form8.t_rem);
                        modify("word14", Form7.word14, Form8.t_rem);
                        modify("word21", Form7.word21, Form8.t_rem);
                        modify("word22", Form7.word22, Form8.t_rem);
                        modify("word23", Form7.word23, Form8.t_rem);
                        modify("word24", Form7.word24, Form8.t_rem);
                        modify("word31", Form7.word31, Form8.t_rem);
                        modify("word32", Form7.word32, Form8.t_rem);
                        modify("word33", Form7.word33, Form8.t_rem);
                        modify("word34", Form7.word34, Form8.t_rem);
                        modify("word41", Form7.word41, Form8.t_rem);
                        modify("word42", Form7.word42, Form8.t_rem);
                        modify("word43", Form7.word43, Form8.t_rem);
                        modify("word44", Form7.word44, Form8.t_rem);
                        modify("word51", Form7.word51, Form8.t_rem);
                        modify("word52", Form7.word52, Form8.t_rem);
                        modify("word53", Form7.word53, Form8.t_rem);
                        modify("word54", Form7.word54, Form8.t_rem);
                    }
                }
            }
            disp_recs();
        }

        private void modify(String field, String value, String id)
        {
            var update = Builders<BsonDocument>.Update.Set(field, value);
            var filter = Builders<BsonDocument>.Filter.Eq("ID", id);
            var options = new UpdateOptions { IsUpsert = true };
            var collection = database.GetCollection<BsonDocument>("Words");
            collection.UpdateOne(filter, update, options);
        }
        private String get_value(String id, String field)
        {
            var sl = database.GetCollection<BsonDocument>("Words");
            var filter = Builders<BsonDocument>.Filter.Eq("ID", id);
            var doc = sl.Find(filter).FirstOrDefault();
            return doc[field].ToString();
        }
    }
}