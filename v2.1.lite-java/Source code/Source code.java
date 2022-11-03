/*
Worderize Lite
Distributed under the MIT License
© Copyright Maxim Bortnikov 2022
For more information please visit
https://github.com/Northstrix/Worderize
*/
/*
Implementation of DES by David Simmons was taken from https://github.com/simmons/desdemo

* Copyright 2011 David Simmons
* http://cafbit.com/
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
 */
import java.awt.*;
import java.awt.event.*;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyleConstants;
import java.io.*;
import java.lang.*;
import java.security.SecureRandom;
import java.security.Security;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

class Worderize_main
extends JFrame {
	
    public Container c;
    public static JLabel l1;
    public static JLabel l2;
    public static JLabel l3;
    public static JLabel w11;
    public static JLabel w12;
    public static JLabel w13;
    public static JLabel w21;
    public static JLabel w22;
    public static JLabel w23;
    public static JLabel w31;
    public static JLabel w32;
    public static JLabel w33;
    public static TextField tl1;
    public static TextField tl2;
    public static TextField tl3;
    public static TextField tw11;
    public static TextField tw12;
    public static TextField tw13;
    public static TextField tw21;
    public static TextField tw22;
    public static TextField tw23;
    public static TextField tw31;
    public static TextField tw32;
    public static TextField tw33;
    public static JLabel q1;
    public static JLabel q2;
    public static JLabel q3;
    public static JLabel q4;
    public static JLabel q5;
    public static JLabel q6;
    public static JLabel q7;
    public static JLabel q8;
    public static JLabel q9;
    public static JLabel q10;
    public static JLabel q11;
    public static JLabel q12;
    public JMenuBar menu_b;
    public static JMenu filem, wordm, tripm, flcmenu, languagem, helpm;
    public static JMenuItem genck, senck, clsprg, addw, addhw, editw, dltw, vieww, view_rw, createt, deletet, viewt, view_rt, createf, deletef, viewf, view_rf, engll, deutl, frenl, about_worderize;
    static Color black_cl = new Color(31, 31, 34);
    static Color bclr = new Color(18, 140, 182);
    static Color gclr = new Color(18, 141, 182);
    static Color button_backg_cl = new Color(255, 185, 16);
    static Color red_cl = new Color(235, 53, 16);
    static Color frclr = new Color(238, 238, 238);
    static Color men_cl = new Color(29, 68, 90);

    public static String current_language = "en";
    public static String select_key_message = "Please select an encryption key to continue.\nFile -> Select encryption key";
    public static String err_del_message = "Can't delete the word because it's present in at least one triplet!";
    public static String err_del_message1 = "Can't delete the triplet because it's present in at least one flashcard!";

    public Worderize_main() {
        setTitle("Worderize Lite");
        setBounds(300, 90, 356, 242); //1008
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        menu_b = new JMenuBar();
        filem = new JMenu(" File ");
        genck = new JMenuItem("Generate encryption key");
        senck = new JMenuItem("Select encryption key");
        clsprg = new JMenuItem("Quit");
        filem.add(genck);
        filem.add(senck);
        filem.add(clsprg);
        menu_b.add(filem);
        wordm = new JMenu("  Word  ");
        addw = new JMenuItem("Add");
        addhw = new JMenuItem("Add Hebrew Word");
        editw = new JMenuItem("Edit");
        dltw = new JMenuItem("Delete");
        vieww = new JMenuItem("View");
        view_rw = new JMenuItem("View Random");
        wordm.add(addw);
        wordm.add(addhw);
        wordm.add(editw);
        wordm.add(dltw);
        wordm.add(vieww);
        wordm.add(view_rw);
        menu_b.add(wordm);
        tripm = new JMenu(" Triplet ");
        createt = new JMenuItem("Create");
        deletet = new JMenuItem("Delete");
        viewt = new JMenuItem("View");
        view_rt = new JMenuItem("View Random");
        tripm.add(createt);
        tripm.add(deletet);
        tripm.add(viewt);
        tripm.add(view_rt);
        menu_b.add(tripm);
        flcmenu = new JMenu(" Flashcard ");
        createf = new JMenuItem("Create");
        deletef = new JMenuItem("Delete");
        viewf = new JMenuItem("View");
        view_rf = new JMenuItem("View Random");
        flcmenu.add(createf);
        flcmenu.add(deletef);
        flcmenu.add(viewf);
        flcmenu.add(view_rf);
        menu_b.add(flcmenu);
        languagem = new JMenu(" Language ");
        engll = new JMenuItem ("English");
        deutl = new JMenuItem ("Deutsch");
        frenl = new JMenuItem ("Français");
        languagem.add(engll);
        languagem.add(deutl);
        languagem.add(frenl);
        menu_b.add(languagem);
        helpm = new JMenu(" Help ");
        about_worderize = new JMenuItem("About Worderize Lite");
        helpm.add(about_worderize);
        menu_b.add(helpm);
        setJMenuBar(menu_b);

        l1 = new JLabel("", SwingConstants.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setSize(310, 20);
        l1.setLocation(15, 20);
        c.add(l1);

        l2 = new JLabel("", SwingConstants.CENTER);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setSize(310, 20);
        l2.setLocation(340, 20);
        c.add(l2);

        l3 = new JLabel("", SwingConstants.CENTER);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setSize(310, 20);
        l3.setLocation(665, 20);
        c.add(l3);

        w11 = new JLabel("", SwingConstants.CENTER);
        w11.setFont(new Font("Arial", Font.BOLD, 20));
        w11.setSize(310, 20);
        w11.setLocation(15, 59);
        c.add(w11);

        w12 = new JLabel("", SwingConstants.CENTER);
        w12.setFont(new Font("Arial", Font.BOLD, 20));
        w12.setSize(310, 20);
        w12.setLocation(340, 59);
        c.add(w12);

        w13 = new JLabel("", SwingConstants.CENTER);
        w13.setFont(new Font("Arial", Font.BOLD, 20));
        w13.setSize(310, 20);
        w13.setLocation(665, 59);
        c.add(w13);

        w21 = new JLabel("", SwingConstants.CENTER);
        w21.setFont(new Font("Arial", Font.BOLD, 20));
        w21.setSize(310, 20);
        w21.setLocation(15, 89);
        c.add(w21);

        w22 = new JLabel("", SwingConstants.CENTER);
        w22.setFont(new Font("Arial", Font.BOLD, 20));
        w22.setSize(310, 20);
        w22.setLocation(340, 89);
        c.add(w22);

        w23 = new JLabel("", SwingConstants.CENTER);
        w23.setFont(new Font("Arial", Font.BOLD, 20));
        w23.setSize(310, 20);
        w23.setLocation(665, 89);
        c.add(w23);

        w31 = new JLabel("", SwingConstants.CENTER);
        w31.setFont(new Font("Arial", Font.BOLD, 20));
        w31.setSize(310, 20);
        w31.setLocation(15, 119);
        c.add(w31);

        w32 = new JLabel("", SwingConstants.CENTER);
        w32.setFont(new Font("Arial", Font.BOLD, 20));
        w32.setSize(310, 20);
        w32.setLocation(340, 119);
        c.add(w32);

        w33 = new JLabel("", SwingConstants.CENTER);
        w33.setFont(new Font("Arial", Font.BOLD, 20));
        w33.setSize(310, 20);
        w33.setLocation(665, 119);
        c.add(w33);

        c.setBackground(bclr);
        menu_b.setBackground(men_cl);

        filem.setForeground(frclr);
        wordm.setForeground(frclr);
        tripm.setForeground(frclr);
        flcmenu.setForeground(frclr);
        helpm.setForeground(frclr);
        languagem.setForeground(frclr);
        
        genck.setBackground(men_cl);
        senck.setBackground(men_cl);
        clsprg.setBackground(men_cl);
        addw.setBackground(men_cl);
        addhw.setBackground(men_cl);
        editw.setBackground(men_cl);
        dltw.setBackground(men_cl);
        vieww.setBackground(men_cl);
        view_rw.setBackground(men_cl);
        createt.setBackground(men_cl);
        deletet.setBackground(men_cl);
        viewt.setBackground(men_cl);
        view_rt.setBackground(men_cl);
        createf.setBackground(men_cl);
        deletef.setBackground(men_cl);
        viewf.setBackground(men_cl);
        view_rf.setBackground(men_cl);
        engll.setBackground(men_cl);
        deutl.setBackground(men_cl);
        frenl.setBackground(men_cl);
        about_worderize.setBackground(men_cl);
        
        genck.setForeground(frclr);
        senck.setForeground(frclr);
        clsprg.setForeground(frclr);
        addw.setForeground(frclr);
        addhw.setForeground(frclr);
        editw.setForeground(frclr);
        dltw.setForeground(frclr);
        vieww.setForeground(frclr);
        view_rw.setForeground(frclr);
        createt.setForeground(frclr);
        deletet.setForeground(frclr);
        viewt.setForeground(frclr);
        view_rt.setForeground(frclr);
        createf.setForeground(frclr);
        deletef.setForeground(frclr);
        viewf.setForeground(frclr);
        view_rf.setForeground(frclr);
        engll.setForeground(frclr);
        deutl.setForeground(frclr);
        frenl.setForeground(frclr);
        about_worderize.setForeground(frclr);
        
        l1.setForeground(frclr);
        l2.setForeground(frclr);
        l3.setForeground(frclr);
        w11.setForeground(frclr);
        w12.setForeground(frclr);
        w13.setForeground(frclr);
        w21.setForeground(frclr);
        w22.setForeground(frclr);
        w23.setForeground(frclr);
        w31.setForeground(frclr);
        w32.setForeground(frclr);
        w33.setForeground(frclr);
        
        genck.addActionListener(e ->
        {
        	generate_key();
        });
        
        senck.addActionListener(e ->
        {
        	select_key();
        });
        
        clsprg.addActionListener(e ->
        {
          System.exit(0); 
        });
        
        addw.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		add_word_to_db();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        addhw.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		add_hebrew_word_to_db();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        editw.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		edit_rec_from_words();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });

        dltw.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
                delete_rec_from_words();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        vieww.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		view_rec_from_words();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        view_rw.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		view_rand_word();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        createt.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		create_triplet();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        deletet.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		delete_rec_from_triplets();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        viewt.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		view_rec_from_triplets();
        		setBounds(300, 90, 356, 242);
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        view_rt.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		view_rand_rec_from_triplets();
        		setBounds(300, 90, 356, 242);
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        createf.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		create_flashcard();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        deletef.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		delete_rec_from_flashcards();
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        viewf.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		view_rec_from_flashcards();
        		setBounds(300, 90, 1006, 242);
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        view_rf.addActionListener(e ->
        {
        	if (ck != null && !ck.isEmpty()) {
        		view_rand_rec_from_flashcards();
        		setBounds(300, 90, 1006, 242);
        	}
        	else {
                JFrame f6 = new JFrame();
              	JOptionPane.showMessageDialog(f6, select_key_message, "Error", JOptionPane.WARNING_MESSAGE);
        	}
        });
        
        engll.addActionListener(e ->
        {
        	set_english();
        	exp_setttings();
          });
        
        deutl.addActionListener(e ->
        {
        	set_deutsch();
        	exp_setttings();
          });
        
        frenl.addActionListener(e ->
        {
        	set_french();
        	exp_setttings();
          });
        
        about_worderize.addActionListener(e ->
        {
        	about_wrd();
          });
        
        setVisible(true);
    }
    
    public static void set_english() {
    	current_language = "en";
    	select_key_message = "Please select an encryption key to continue.\nFile -> Select encryption key";
    	err_del_message = "Can't delete the word because it's present in at least one triplet!";
    	err_del_message1 = "Can't delete the triplet because it's present in at least one flashcard!";
    	filem.setText("File");
    	languagem.setText("Language");
    	wordm.setText("Word");
        genck.setText("Generate encryption key");
        senck.setText("Select encryption key");
        clsprg.setText("Quit");
        dltw.setText("Delete");
        deletet.setText("Delete");
        deletef.setText("Delete");
        editw.setText("Edit");
        vieww.setText("View");
        viewt.setText("View");
        viewf.setText("View");
        view_rw.setText("View Random");
        view_rt.setText("View Random");
        view_rf.setText("View Random");
        addw.setText("Add");
        createt.setText("Create");
        createf.setText("Create");
    }
    
    public static void set_deutsch() {
    	current_language = "de";
    	select_key_message = "Bitte wählen Sie einen Verschlüsselungsschlüssel aus, um fortzufahren.\nDatei -> Verschlüsselungsschlüssel auswählen";
    	err_del_message = "Das Wort kann nicht gelöscht werden, da es in mindestens einem Triplett vorhanden ist!";
    	err_del_message1 = "Das Triplett kann nicht gelöscht werden, da es in mindestens einer Flashcarde vorhanden ist!";
    	filem.setText("Datei");
    	languagem.setText("Sprache");
    	wordm.setText("Wort");
        genck.setText("Verschlüsselungsschlüssel generieren");
        senck.setText("Verschlüsselungsschlüssel auswählen");
        clsprg.setText("Beenden");
        dltw.setText("Löschen");
        deletet.setText("Löschen");
        deletef.setText("Löschen");
        editw.setText("Bearbeiten");
        vieww.setText("Ansicht");
        viewt.setText("Ansicht");
        viewf.setText("Ansicht");
        view_rw.setText("Zufällig ansehen");
        view_rt.setText("Zufällig ansehen");
        view_rf.setText("Zufällig ansehen");
        addw.setText("Hinzufügen");
        createt.setText("Erstellen");
        createf.setText("Erstellen");
    }
    
    public static void set_french() {
    	current_language = "fr";
    	select_key_message = "Veuillez sélectionner une clé de cryptage pour continuer.\nFicher -> Sélectionnez la clé de chiffrement";
    	err_del_message = "Impossible de supprimer le mot car il est présent dans au moins un triplet!";
    	err_del_message1 = "Impossible de supprimer le triplet car il est présent dans au moins une flashcard!";
    	filem.setText("Ficher");
    	languagem.setText("Langue");
    	wordm.setText("Mot");
        genck.setText("Générer la clé de chiffrement");
        senck.setText("Sélectionnez la clé de chiffrement");
        clsprg.setText("Quitter");
        dltw.setText("Supprimer");
        deletet.setText("Supprimer");
        deletef.setText("Supprimer");
        editw.setText("Modifiez");
        vieww.setText("Voir");
        viewt.setText("Voir");
        viewf.setText("Voir");
        view_rw.setText("Voir aléatoire");
        view_rt.setText("Voir aléatoire");
        view_rf.setText("Voir aléatoire");
        addw.setText("Ajouter");
        createt.setText("Créer");
        createf.setText("Créer");
    }
 
    public static void crfl() {
    	try {
    		File myObj = new File("config.txt");
    	    if (myObj.createNewFile()) {
    	      try {
    	          FileWriter myWriter = new FileWriter("config.txt");
    	          myWriter.write(current_language);
    	          myWriter.close();
    	        } catch (IOException e) {
    	          e.printStackTrace();
    	        }
    	    }
    	}
    	catch (IOException e) {
    	    e.printStackTrace();
    	}
    }
    
    public static void imp_setttings() {
    	try {
    		// Creating an object of the file for reading the data
    		File myObj = new File("config.txt");  
    		Scanner myReader = new Scanner(myObj);
    		String imps = "";
    		while (myReader.hasNextLine()) {
    		imps += myReader.nextLine();
    		}
    		if (imps.charAt(0) == 'e')
    			set_english();
    		if (imps.charAt(0) == 'd')
    			set_deutsch();
    		if (imps.charAt(0) == 'f')
    			set_french();
    		myReader.close();
    		//System.out.println(imps);
    		} catch (FileNotFoundException e) {
    		System.out.println("An error occurred.");
    		e.printStackTrace();
    		}
    }
    
    public static void exp_setttings() {
        try {
            FileWriter myWriter = new FileWriter("config.txt");
            myWriter.write(current_language);
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
    public static void add_word_to_db() {
        JFrame framep = new JFrame("Add Word");  
        framep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Container cp = framep.getContentPane();  
        JTextPane pane = new JTextPane();  
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
  
        pane.setCharacterAttributes(attributeSet, true);
        pane.setFont(new Font("Arial", Font.BOLD, 20)); 
  
        Document doc = pane.getStyledDocument();  
        try {
			doc.insertString(doc.getLength(), "Enter the Definition...", attributeSet);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}  
        JScrollPane scrollPane = new JScrollPane(pane);  
        cp.add(scrollPane, BorderLayout.CENTER);  
        
        pane.setForeground(frclr);
        pane.setBackground(black_cl);
        JMenuBar menu_bp = new JMenuBar();
        JButton add_r = new JButton("Add");
        JButton canc = new JButton("Cancel");
        tl1 = new TextField("", SwingConstants.CENTER);
        tl1.setFont(new Font("Arial", Font.BOLD, 20));
        tl1.setText("Enter the Word...");
        menu_bp.add(tl1);
        menu_bp.add(add_r);
        menu_bp.add(canc);
        tl1.setBackground(black_cl);
        add_r.setBackground(gclr);
        canc.setBackground(button_backg_cl);
        tl1.setForeground(frclr);
        add_r.setForeground(frclr);
        canc.setForeground(black_cl);
        framep.setJMenuBar(menu_bp);
        framep.setSize(440, 320);  
        framep.setVisible(true);
        framep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        add_r.addActionListener(e -> {
            enc_str = "";
            encrypt_string(gen_trash() + tl1.getText());
            String enc_word = enc_str;
            enc_str = "";
            set_salt_and_iv();
            encrypt_string(gen_trash() + pane.getText());
            set_salt_and_iv();
            add_word_to_db(Base64.getEncoder().encodeToString(enc_word.getBytes()), Base64.getEncoder().encodeToString(enc_str.getBytes()));
            enc_str = "";
        	framep.dispose();
        });
        canc.addActionListener(e -> {
            framep.dispose();
        });
    }
    
    public static void add_hebrew_word_to_db() {
    	Hebrew_keyboard frameh = new Hebrew_keyboard();
        frameh.setTitle("Add Hebrew Word");
        frameh.setVisible(true);
        frameh.setBounds(10,10,536,600);
        frameh.setResizable(false);
        frameh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public static String gen_trash() {
    	StringBuilder trash = new StringBuilder();
        SecureRandom number = new SecureRandom();
        for (int i = 0; i < 4; i++) {
        trash.append((char) (number.nextInt(256)));
        }
        
    	return trash.toString();
    }
 
    public static void about_wrd() {

        JFrame about_pr = new JFrame("About Worderize Lite");

        about_pr.setBounds(300, 90, 600, 224);
        about_pr.setResizable(false);
        JPanel c1 = new JPanel(new SpringLayout());

        q1 = new JLabel("Worderize Lite is a free and open-source software distributed under the", SwingConstants.CENTER);
        q1.setFont(new Font("Arial", Font.BOLD, 14));
        c1.add(q1);

        q2 = new JLabel("MIT License, that is designed to make the language learning more effective.", SwingConstants.CENTER);
        q2.setFont(new Font("Arial", Font.BOLD, 14));
        c1.add(q2);

        q3 = new JLabel("For more information please visit:", SwingConstants.CENTER);
        q3.setFont(new Font("Arial", Font.BOLD, 14));
        c1.add(q3);

        tl1 = new TextField("https://github.com/Northstrix/Worderize", SwingConstants.CENTER);
        tl1.setFont(new Font("Arial", Font.BOLD, 14));
        c1.add(tl1);

        tl2 = new TextField("https://sourceforge.net/projects/worderize-lite/", SwingConstants.CENTER);
        tl2.setFont(new Font("Arial", Font.BOLD, 14));
        c1.add(tl2);

        tl3 = new TextField("https://osdn.net/projects/worderize-lite/", SwingConstants.CENTER);
        tl3.setFont(new Font("Arial", Font.BOLD, 14));
        c1.add(tl3);

        JButton cl1 = new JButton("OK");

        c1.setBackground(gclr);
        q1.setForeground(frclr);
        q2.setForeground(frclr);
        q3.setForeground(frclr);
        tl1.setForeground(frclr);
        tl2.setForeground(frclr);
        tl3.setForeground(frclr);
        tl1.setBackground(gclr);
        tl2.setBackground(gclr);
        tl3.setBackground(gclr);
        cl1.setForeground(frclr);
        cl1.setBackground(gclr);

        c1.add(cl1);

        about_pr.add(c1);
        c1.setLayout(new GridLayout(7, 1));
        about_pr.setVisible(true);
        about_pr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cl1.addActionListener(e -> {
            about_pr.dispose();
        });
    }
    
    public static void generate_key() {
  	  	SecureRandom desk = new SecureRandom();
  	  	SecureRandom slct = new SecureRandom();
  	  	StringBuilder dk = new StringBuilder();
  		for(int i = 0; i < 16; i++) {
  			if(slct.nextInt(2) == 1) {
  				dk.append((char) (48 + desk.nextInt(10)));
  			}
  			else {
  				dk.append((char) (65 + desk.nextInt(6)));
  			}
  		}
  		//System.out.println(dk.toString());
  	  	int gv = 0;
  	  	SecureRandom aesk = new SecureRandom();
  	  	StringBuilder aeskey = new StringBuilder();
  	  	gv = 0;
  	  	int adl = aesk.nextInt(200);
  		for(int i = 0; i < 320 + adl; i++) {
  			gv = 32 + aesk.nextInt(94);
  			if(gv != 44)
  				aeskey.append((char) gv);
  			else {
  				aeskey.append((char) gv + 2 + aesk.nextInt(74));
  			}
  		}
  		//System.out.println(aeskey.toString());
    	JFrame parentFrame = new JFrame();
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setDialogTitle("Choose where to save newly generated key");   
    	int userSelection = fileChooser.showSaveDialog(parentFrame);
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    	    File fileToSave = fileChooser.getSelectedFile();
        		FileWriter myWriter;
				try {
					myWriter = new FileWriter(fileToSave.getAbsolutePath());
                    myWriter.write(dk.toString() + "," + aeskey.toString());
                    myWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

                //System.out.println("Successfully wrote to the file.");
      	  	  	SecureRandom numb1 = new SecureRandom();
      	  	  	for (int i = 0; i < 16; i++) {
    	  		  	iv[i]= (byte) numb1.nextInt(256); 
      	  	  	}
              }
    }
    
    public static void select_key() {
        final JFrame iFRAME = new JFrame();
        iFRAME.setAlwaysOnTop(true);
        iFRAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iFRAME.setLocationRelativeTo(null);
        iFRAME.requestFocus();

        JFileChooser jfc = new JFileChooser();
        int returnValue = jfc.showOpenDialog(iFRAME);
        iFRAME.dispose();
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            // Display selected file in console
            //System.out.println(selectedFile.getAbsolutePath());
            try {
                String result = null;

                DataInputStream reader = new DataInputStream(new FileInputStream(selectedFile.getAbsolutePath()));
                int nBytesToRead = reader.available();
                if(nBytesToRead > 0) {
                    byte[] bytes = new byte[nBytesToRead];
                    reader.read(bytes);
                    result = new String(bytes);
                }
                //System.out.println(result);
                String[] e_keys = result.split(",");
                ck = e_keys[0];
                SECRET_KEY = e_keys[1];
              } catch (IOException r) {
                  System.out.println("An error occurred.");
                  r.printStackTrace();
                }
        }
    }
    
    public static String gen_rnd(int n) {
        StringBuilder str = new StringBuilder();
        SecureRandom number = new SecureRandom();
        for (int i = 0; i < n; i++) {
            str.append((char)(65 + (number.nextInt(26))));
        }
        return str.toString();
    }

    public static void create_tables() {
    	exeq_sql_statement("CREATE TABLE if not exists Words (ID TEXT NOT NULL, Word TEXT NOT NULL, Definition TEXT NOT NULL)");
    	exeq_sql_statement("CREATE TABLE if not exists Triplets (ID TEXT NOT NULL, Language TEXT NOT NULL, Word1 TEXT NOT NULL, Word2 TEXT NOT NULL, Word3 TEXT NOT NULL)");
    	exeq_sql_statement("CREATE TABLE if not exists Flashcards (ID TEXT NOT NULL, Triplet1 TEXT NOT NULL, Triplet2 TEXT NOT NULL, Triplet3 TEXT NOT NULL)");
    }
    
    public static void exeq_sql_statement(String sql) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            JFrame f1 = new JFrame();
            JOptionPane.showMessageDialog(f1, e.getClass().getName() + ": " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        return;
    }
    
    public static void add_word_to_db(String word, String defnt) {
        String id = gen_rnd(96);
        exeq_sql_statement("INSERT INTO Words (ID, Word, Definition) VALUES ('" + id + "', '" + word + "', '" + defnt + "' );");
        return;
    }

    public static void edit_rec_from_words() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Words");
            JFrame viewrec = new JFrame("Edit word");
            JMenuBar rm = new JMenuBar();
            int nmb_of_r = number_of_recs("Words");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                dec_str = "";
                decrypt_string(enc_str);
                String qw11 = rs.getString("Word");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                String shrtnd_str ="";
                if (qw11 != null &&  dec_str.isEmpty() == false)
                	shrtnd_str = dec_str.substring(4);
                rcrds[n][1] = (shrtnd_str);
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
            }
            viewrec.setJMenuBar(rm);
            rm.add(records);
            JButton editb = new JButton("Edit");
            JButton cncl = new JButton("Cancel");
            rm.add(editb);
            rm.add(cncl);
            cncl.setForeground(black_cl);
            cncl.setBackground(button_backg_cl);
            editb.setForeground(frclr);
            editb.setBackground(gclr);
            viewrec.setSize(600, 68);
            viewrec.setVisible(true);
            viewrec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
            editb.addActionListener(e -> {
            	disp_word_for_edit(rcrds[records.getSelectedIndex()][0]);
                viewrec.dispose();

            });
            cncl.addActionListener(e -> {
                viewrec.dispose();

            });
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static void disp_word_for_edit(String id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Words WHERE ID = '" + id + "'");
            while (rs.next()) {
                String qw11 = rs.getString("Word");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                String shrtnd_str ="";
                if (qw11 != null  && dec_str.isEmpty() == false)
                	shrtnd_str = dec_str.substring(4);
                
                String qw12 = rs.getString("Definition");
                byte[] decodedBytes12 = Base64.getDecoder().decode(qw12);
                String dw12 = new String(decodedBytes12);
                dec_str = "";
                decrypt_string(dw12);
                String shrtnd_str2 ="";
                if (qw12 != null && dec_str.isEmpty() == false)
                	shrtnd_str2 = dec_str.substring(4);
                
                if (shrtnd_str.isEmpty() == false) {
                	while (shrtnd_str.charAt(shrtnd_str.length()-1) == 0) {
                		shrtnd_str = shrtnd_str.substring(0, shrtnd_str.length() - 1);  
                	}
                }
                
                if (shrtnd_str2.isEmpty() == false) {
                	while (shrtnd_str2.charAt(shrtnd_str2.length()-1) == 0) {
                		shrtnd_str2 = shrtnd_str2.substring(0, shrtnd_str2.length() - 1);  
                	}
                }
                
                JFrame framep = new JFrame(shrtnd_str);
                Container cp = framep.getContentPane();  
                JTextPane pane = new JTextPane();  
                SimpleAttributeSet attributeSet = new SimpleAttributeSet();
          
                pane.setCharacterAttributes(attributeSet, true);
                pane.setFont(new Font("Arial", Font.BOLD, 20)); 
          
                Document doc = pane.getStyledDocument();  
                try {
        			doc.insertString(doc.getLength(), shrtnd_str2 , attributeSet);
        		} catch (BadLocationException e) {
        			e.printStackTrace();
        		}  
                JScrollPane scrollPane = new JScrollPane(pane);  
                cp.add(scrollPane, BorderLayout.CENTER);  
                
                pane.setForeground(frclr);
                pane.setBackground(black_cl);
                JMenuBar menu_bp = new JMenuBar();
                JButton add_r = new JButton("Save");
                JButton canc = new JButton("Cancel");
                tl1 = new TextField("", SwingConstants.CENTER);
                tl1.setFont(new Font("Arial", Font.BOLD, 20));
                tl1.setText(shrtnd_str);
                menu_bp.add(tl1);
                menu_bp.add(add_r);
                menu_bp.add(canc);
                tl1.setBackground(black_cl);
                add_r.setBackground(gclr);
                canc.setBackground(button_backg_cl);
                tl1.setForeground(frclr);
                add_r.setForeground(frclr);
                canc.setForeground(black_cl);
                framep.setJMenuBar(menu_bp);
                framep.setSize(440, 320);  
                framep.setVisible(true);
                framep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                add_r.addActionListener(e -> {
                    enc_str = "";
                    encrypt_string(gen_trash() + tl1.getText());
                    String enc_word = enc_str;
                    enc_str = "";
                    set_salt_and_iv();
                    encrypt_string(gen_trash() + pane.getText());
                    set_salt_and_iv();
                    update_word(Base64.getEncoder().encodeToString(enc_word.getBytes()), Base64.getEncoder().encodeToString(enc_str.getBytes()), id);
                    enc_str = "";
                	framep.dispose();
                });
                canc.addActionListener(e -> {
                    framep.dispose();
                });
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            JFrame f5 = new JFrame();
            JOptionPane.showMessageDialog(f5, e.getClass().getName() + ": " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void update_word(String word, String defn, String id) {
    	exeq_sql_statement("UPDATE Words SET Word = '" + word + "', Definition = '" + defn + "' WHERE ID = '" + id + "';");
    }
    
    public static void view_rand_word() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Words");
            int nmb_of_r = number_of_recs("Words");
            String rcrds[] = new String[nmb_of_r + 1];
            int n = 0;
            while (rs.next()) {
                rcrds[n] = (rs.getString("ID"));
                n++;
            }
            rs.close();
            stmt.close();
            c.close();
            SecureRandom number = new SecureRandom();
            int rn = number.nextInt(n);
            disp_sel_word(rcrds[rn]);
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static void view_rec_from_words() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Words");
            JFrame viewrec = new JFrame("View word");
            JMenuBar rm = new JMenuBar();
            int nmb_of_r = number_of_recs("Words");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                dec_str = "";
                decrypt_string(enc_str);
                String qw11 = rs.getString("Word");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                String shrtnd_str ="";
                if (qw11 != null && dec_str.isEmpty() == false)
                	shrtnd_str = dec_str.substring(4);
                rcrds[n][1] = (shrtnd_str);
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
            }
            viewrec.setJMenuBar(rm);
            rm.add(records);
            JButton viewb = new JButton("View");
            JButton cncl = new JButton("Cancel");
            rm.add(viewb);
            rm.add(cncl);
            cncl.setForeground(black_cl);
            cncl.setBackground(button_backg_cl);
            viewb.setForeground(frclr);
            viewb.setBackground(gclr);
            viewrec.setSize(600, 68);
            viewrec.setVisible(true);
            viewrec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
            viewb.addActionListener(e -> {
            	disp_sel_word(rcrds[records.getSelectedIndex()][0]);
                viewrec.dispose();

            });
            cncl.addActionListener(e -> {
                viewrec.dispose();

            });
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static void disp_sel_word(String id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Words WHERE ID = '" + id + "'");
            while (rs.next()) {
                String qw11 = rs.getString("Word");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                String shrtnd_str ="";
                if (qw11 != null && dec_str.isEmpty() == false)
                	shrtnd_str = dec_str.substring(4);
                
                String qw12 = rs.getString("Definition");
                byte[] decodedBytes12 = Base64.getDecoder().decode(qw12);
                String dw12 = new String(decodedBytes12);
                dec_str = "";
                decrypt_string(dw12);
                String shrtnd_str2 ="";
                if (qw12 != null && dec_str.isEmpty() == false)
                	shrtnd_str2 = dec_str.substring(4);
                
                if (shrtnd_str.isEmpty() == false) {
                	while (shrtnd_str.charAt(shrtnd_str.length()-1) == 0) {
                		shrtnd_str = shrtnd_str.substring(0, shrtnd_str.length() - 1);  
                	}
                }
                
                if (shrtnd_str2.isEmpty() == false) {
                	while (shrtnd_str2.charAt(shrtnd_str2.length()-1) == 0) {
                		shrtnd_str2 = shrtnd_str2.substring(0, shrtnd_str2.length() - 1);  
                	}
                }
                
                JFrame framep = new JFrame(shrtnd_str);
                Container cp = framep.getContentPane();  
                JTextPane pane = new JTextPane();  
                SimpleAttributeSet attributeSet = new SimpleAttributeSet();
          
                pane.setCharacterAttributes(attributeSet, true);
                pane.setFont(new Font("Arial", Font.BOLD, 20)); 
          
                Document doc = pane.getStyledDocument();  
                try {
        			doc.insertString(doc.getLength(), "Definition: " + shrtnd_str2 , attributeSet);
        		} catch (BadLocationException e) {
        			e.printStackTrace();
        		}  
                JScrollPane scrollPane = new JScrollPane(pane);  
                cp.add(scrollPane, BorderLayout.CENTER);  
                
                pane.setForeground(frclr);
                pane.setBackground(black_cl);
                JMenuBar menu_bp = new JMenuBar();
                JButton clsf = new JButton("OK");
                tl1 = new TextField("", SwingConstants.CENTER);
                tl1.setFont(new Font("Arial", Font.BOLD, 20));
                tl1.setText("Word: " + shrtnd_str);
                menu_bp.add(tl1);
                menu_bp.add(clsf);
                tl1.setBackground(black_cl);
                clsf.setBackground(gclr);
                tl1.setForeground(frclr);
                clsf.setForeground(frclr);
                framep.setJMenuBar(menu_bp);
                framep.setSize(440, 320);  
                framep.setVisible(true);
                framep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                clsf.addActionListener(e -> {
                    framep.dispose();
                });
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            JFrame f5 = new JFrame();
            JOptionPane.showMessageDialog(f5, e.getClass().getName() + ": " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    public static void remove_rec(String table, String t_rem) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE from " + table + " where ID='" + t_rem + "';";
            stmt.executeUpdate(sql);
            c.commit();
            c.close();
        } catch (Exception e) {
            JFrame f6 = new JFrame();
            JOptionPane.showMessageDialog(f6, e.getClass().getName() + ": " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        return;
    }

    public static int number_of_recs(String table) {
        Connection c = null;
        Statement stmt = null;
        int nmb = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+ table +";");
            while (rs.next()) {
                nmb++;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return nmb;
    }

    public static void delete_rec_from_words() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Words");
            JFrame remrec = new JFrame("Delete word");
            JMenuBar rm = new JMenuBar();
            int nmb_of_r = number_of_recs("Words");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                String qw11 = rs.getString("Word");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                String shrtnd_str ="";
                if (qw11 != null && dec_str.isEmpty() == false)
                	shrtnd_str = dec_str.substring(4);
                rcrds[n][1] = (shrtnd_str);
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
            }
            remrec.setJMenuBar(rm);
            rm.add(records);
            JButton rmv = new JButton("Delete");
            JButton cncl = new JButton("Cancel");
            rm.add(rmv);
            rm.add(cncl);
            rmv.setForeground(frclr);
            rmv.setBackground(red_cl);
            cncl.setForeground(frclr);
            cncl.setBackground(gclr);
            remrec.setSize(600, 68);
            remrec.setVisible(true);
            remrec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
            rmv.addActionListener(e -> {
            		if (check_presence_in_triplets(rcrds[records.getSelectedIndex()][0]) == 0)
            			remove_rec("Words", rcrds[records.getSelectedIndex()][0]);
            		else {
            			JFrame f9 = new JFrame();
            			JOptionPane.showMessageDialog(f9, err_del_message);
            		}
                remrec.dispose();

            });
            cncl.addActionListener(e -> {
                remrec.dispose();

            });
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static int check_presence_in_triplets(String r_t_e) {
        Connection c = null;
        Statement stmt = null;
        int rm = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets;");
            while (rs.next()) {
            	if (rs.getString("Word1").equals(r_t_e) || rs.getString("Word2").equals(r_t_e) || rs.getString("Word3").equals(r_t_e))
            		rm = 1;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return rm;
    }
   
    public static void create_triplet() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Words");
            int nmb_of_r = number_of_recs("Words");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            JComboBox records1 = new JComboBox();
            JComboBox records2 = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                dec_str = "";
                decrypt_string(enc_str);
                String qw11 = rs.getString("Word");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                String shrtnd_str ="";
                if (qw11 != null && dec_str.isEmpty() == false)
                	shrtnd_str = dec_str.substring(4);
                rcrds[n][1] = (shrtnd_str);
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
                records1.addItem(rcrds[i][1]);
                records2.addItem(rcrds[i][1]);
            }
    		JFrame addrc = new JFrame("Create triplet");
    		
    		addrc.setBounds(300, 90, 375, 308);
    		addrc.setResizable(false);
    		JPanel c1 = new JPanel(new SpringLayout());

    		JPanel menu_b1 = new JPanel();
    		JButton add_r = new JButton("Create");
    		JButton canc = new JButton("Cancel");
    		menu_b1.add(add_r);
    		menu_b1.add(canc);
    		add_r.setBackground(gclr);
    		canc.setBackground(button_backg_cl);
    		add_r.setForeground(frclr);
    		canc.setForeground(black_cl);
    		
    		q1 = new JLabel(" Language");
    		q1.setFont(new Font("Arial", Font.BOLD, 18));
    		c1.add(q1);
    		tl1 = new TextField("");
    		tl1.setFont(new Font("Arial", Font.BOLD, 18));
    		c1.add(tl1);
    		q4 = new JLabel(" Word 1");
    		q4.setFont(new Font("Arial", Font.BOLD, 18));
    		c1.add(q4);
    		c1.add(records);
    		q7 = new JLabel(" Word 2");
    		q7.setFont(new Font("Arial", Font.BOLD, 18));
    		c1.add(q7);
    		c1.add(records1);
    		q10 = new JLabel(" Word 3");
    		q10.setFont(new Font("Arial", Font.BOLD, 18));
    		c1.add(q10);
    		c1.add(records2);
    		tl1.setForeground(frclr);
    		tl1.setBackground(black_cl);
    		addrc.add(c1);
            addrc.getContentPane().add(BorderLayout.SOUTH, menu_b1);

    	    add_r.addActionListener(e ->
    	    {
                enc_str = "";
                set_salt_and_iv();
                encrypt_string(gen_trash() + tl1.getText());
                set_salt_and_iv();
                add_triplet(Base64.getEncoder().encodeToString(enc_str.getBytes()), rcrds[records.getSelectedIndex()][0], rcrds[records1.getSelectedIndex()][0], rcrds[records2.getSelectedIndex()][0]);
                enc_str = "";
    	    	addrc.dispose();
    	    });
    	    canc.addActionListener(e ->
    	    {
    	    	addrc.dispose();
    	    });
    		
    		c1.setLayout(new GridLayout(8, 1));
    		addrc.setVisible(true);
            addrc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
	}
	
	public static void add_triplet(String lng, String wd1, String wd2, String wd3) {
		String id = gen_rnd(96);
		exeq_sql_statement("INSERT INTO Triplets (ID, Language, Word1, Word2, Word3) VALUES ('" + id + "', '" + lng + "', '" + wd1 + "', '" + wd2 + "', '" + wd3 + "' );");
		return;
	}
    
    public static void delete_rec_from_triplets() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets");
            JFrame remrec = new JFrame("Delete triplet");
            JMenuBar rm = new JMenuBar();
            int nmb_of_r = number_of_recs("Triplets");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                String qw11 = get_word_by_id(rs.getString("Word1"));
                String qw12 = get_word_by_id(rs.getString("Word2"));
                String qw13 = get_word_by_id(rs.getString("Word3"));
                rcrds[n][1] = (qw11 + ", " + qw12 + ", " + qw13);
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
            }
            remrec.setJMenuBar(rm);
            rm.add(records);
            JButton rmv = new JButton("Delete");
            JButton cncl = new JButton("Cancel");
            rm.add(rmv);
            rm.add(cncl);
            rmv.setForeground(frclr);
            rmv.setBackground(red_cl);
            cncl.setForeground(frclr);
            cncl.setBackground(gclr);
            remrec.setSize(600, 68);
            remrec.setVisible(true);
            remrec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
            rmv.addActionListener(e -> {
        		if (check_presence_in_flashcards(rcrds[records.getSelectedIndex()][0]) == 0)
        			remove_rec("Triplets", rcrds[records.getSelectedIndex()][0]);
        		else {
        			JFrame f9 = new JFrame();
        			JOptionPane.showMessageDialog(f9, err_del_message1);
        		}
                remrec.dispose();

            });
            cncl.addActionListener(e -> {
                remrec.dispose();

            });
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
	
    public static int check_presence_in_flashcards(String r_t_e) {
        Connection c = null;
        Statement stmt = null;
        int rm = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Flashcards;");
            while (rs.next()) {
            	if (rs.getString("Triplet1").equals(r_t_e) || rs.getString("Triplet2").equals(r_t_e) || rs.getString("Triplet3").equals(r_t_e))
            		rm = 1;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return rm;
    }
    
    public static String get_word_by_id(String id) {
        Connection c = null;
        Statement stmt = null;
        String word_to_ret = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Word FROM Words WHERE ID = '" + id + "';");
            while (rs.next()) {
                String qw11 = rs.getString("Word");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                
                if (qw11 != null && dec_str.isEmpty() == false)
                	word_to_ret = dec_str.substring(4);
                
                if (word_to_ret.isEmpty() == false) {
                	while (word_to_ret.charAt(word_to_ret.length()-1) == 0) {
                		word_to_ret = word_to_ret.substring(0, word_to_ret.length() - 1);  
                	}
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (word_to_ret.isEmpty() == false) {
        	while (word_to_ret.charAt(word_to_ret.length()-1) == 0) {
        		word_to_ret = word_to_ret.substring(0, word_to_ret.length() - 1);  
        	}
    	}
        
        if (word_to_ret.isEmpty() == false)
        	return word_to_ret;
        else {
        	return " ";
        }
    }
    
    public static void view_rand_rec_from_triplets() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets");
            int nmb_of_r = number_of_recs("Triplets");
            String rcrds[] = new String[nmb_of_r + 1];
            int n = 0;
            while (rs.next()) {
                rcrds[n] = (rs.getString("ID"));
                n++;
            }
            rs.close();
            stmt.close();
            c.close();
            SecureRandom number = new SecureRandom();
            int rn = number.nextInt(n);
            disp_sel_triplet(rcrds[rn]);
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static void view_rec_from_triplets() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets");
            JFrame viewrec = new JFrame("View triplet");
            JMenuBar rm = new JMenuBar();
            int nmb_of_r = number_of_recs("Words");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                String qw11 = get_word_by_id(rs.getString("Word1"));
                String qw12 = get_word_by_id(rs.getString("Word2"));
                String qw13 = get_word_by_id(rs.getString("Word3"));
                rcrds[n][1] = (qw11 + ", " + qw12 + ", " + qw13);
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
            }
            viewrec.setJMenuBar(rm);
            rm.add(records);
            JButton viewb = new JButton("View");
            JButton cncl = new JButton("Cancel");
            rm.add(viewb);
            rm.add(cncl);
            cncl.setForeground(black_cl);
            cncl.setBackground(button_backg_cl);
            viewb.setForeground(frclr);
            viewb.setBackground(gclr);
            viewrec.setSize(600, 68);
            viewrec.setVisible(true);
            viewrec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
            viewb.addActionListener(e -> {
            	disp_sel_triplet(rcrds[records.getSelectedIndex()][0]);
                viewrec.dispose();

            });
            cncl.addActionListener(e -> {
                viewrec.dispose();

            });
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static void disp_sel_triplet(String id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets WHERE ID ='"  + id +"'");
            while (rs.next()) {
                String qw11 = rs.getString("Language");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                String extr_ln = "";
                
                if (qw11 != null && dec_str.isEmpty() == false)
                	extr_ln = dec_str.substring(4);
                
                if (extr_ln.isEmpty() == false) {
                	while (extr_ln.charAt(extr_ln.length()-1) == 0) {
                		extr_ln = extr_ln.substring(0, extr_ln.length() - 1);  
                	}
                }
                
                l1.setText(extr_ln);
                w11.setText(get_word_by_id(rs.getString("Word1")));
                w21.setText(get_word_by_id(rs.getString("Word2")));
                w31.setText(get_word_by_id(rs.getString("Word3")));
                dec_str = "";
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static void create_flashcard() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets");
            int nmb_of_r = number_of_recs("Triplets");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            JComboBox records1 = new JComboBox();
            JComboBox records2 = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                String qw11 = get_word_by_id(rs.getString("Word1"));
                String qw12 = get_word_by_id(rs.getString("Word2"));
                String qw13 = get_word_by_id(rs.getString("Word3"));
                rcrds[n][1] = (qw11 + ", " + qw12 + ", " + qw13);
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
                records1.addItem(rcrds[i][1]);
                records2.addItem(rcrds[i][1]);
            }
    		JFrame addrc = new JFrame("Create flashcard");
    		
    		addrc.setBounds(300, 90, 375, 280);
    		addrc.setResizable(false);
    		JPanel c1 = new JPanel(new SpringLayout());

    		JPanel menu_b1 = new JPanel();
    		JButton add_r = new JButton("Create");
    		JButton canc = new JButton("Cancel");
    		menu_b1.add(add_r);
    		menu_b1.add(canc);
    		add_r.setBackground(gclr);
    		canc.setBackground(button_backg_cl);
    		add_r.setForeground(frclr);
    		canc.setForeground(black_cl);
    		q4 = new JLabel(" Triplet 1");
    		q4.setFont(new Font("Arial", Font.BOLD, 18));
    		c1.add(q4);
    		c1.add(records);
    		q7 = new JLabel(" Triplet 2");
    		q7.setFont(new Font("Arial", Font.BOLD, 18));
    		c1.add(q7);
    		c1.add(records1);
    		q10 = new JLabel(" Triplet 3");
    		q10.setFont(new Font("Arial", Font.BOLD, 18));
    		c1.add(q10);
    		c1.add(records2);
    		addrc.add(c1);
            addrc.getContentPane().add(BorderLayout.SOUTH, menu_b1);

    	    add_r.addActionListener(e ->
    	    {
                add_flashcard(rcrds[records.getSelectedIndex()][0], rcrds[records1.getSelectedIndex()][0], rcrds[records2.getSelectedIndex()][0]);
    	    	addrc.dispose();
    	    });
    	    canc.addActionListener(e ->
    	    {
    	    	addrc.dispose();
    	    });
    		
    		c1.setLayout(new GridLayout(8, 1));
    		addrc.setVisible(true);
            addrc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
	}
    
	public static void add_flashcard(String tp1, String tp2, String tp3) {
		String id = gen_rnd(96);
		exeq_sql_statement("INSERT INTO Flashcards (ID, Triplet1, Triplet2, Triplet3) VALUES ('" + id + "', '" + tp1 + "', '" + tp2 + "', '" + tp3 + "' );");
		return;
	}
    
    public static void delete_rec_from_flashcards() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Flashcards");
            JFrame remrec = new JFrame("Delete flashcard");
            JMenuBar rm = new JMenuBar();
            int nmb_of_r = number_of_recs("Triplets");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                rcrds[n][1] = (get_words_from_triplet_by_id(rs.getString("Triplet1")) + ": " + get_language_from_triplet_by_id(rs.getString("Triplet1")) + ", " + get_language_from_triplet_by_id(rs.getString("Triplet2")) + ", " +  get_language_from_triplet_by_id(rs.getString("Triplet3")));
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
            }
            remrec.setJMenuBar(rm);
            rm.add(records);
            JButton rmv = new JButton("Delete");
            JButton cncl = new JButton("Cancel");
            rm.add(rmv);
            rm.add(cncl);
            rmv.setForeground(frclr);
            rmv.setBackground(red_cl);
            cncl.setForeground(frclr);
            cncl.setBackground(gclr);
            remrec.setSize(720, 68);
            remrec.setVisible(true);
            remrec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
            rmv.addActionListener(e -> {
        		remove_rec("Flashcards", rcrds[records.getSelectedIndex()][0]);
                remrec.dispose();

            });
            cncl.addActionListener(e -> {
                remrec.dispose();

            });
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
	
    public static String get_words_from_triplet_by_id(String id) {
        Connection c = null;
        Statement stmt = null;
        String extr_words = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets WHERE ID ='" + id + "'");
            while (rs.next()) {
                String qw11 = get_word_by_id(rs.getString("Word1"));
                String qw12 = get_word_by_id(rs.getString("Word2"));
                String qw13 = get_word_by_id(rs.getString("Word3"));
                extr_words = (qw11 + ", " + qw12 + ", " + qw13);
                dec_str = "";
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return extr_words;
    }
    
    public static String get_language_from_triplet_by_id(String id) {
        Connection c = null;
        Statement stmt = null;
        String extr_ln = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets WHERE ID ='" + id + "'");
            while (rs.next()) {
                String qw11 = rs.getString("Language");
                byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
                String dw11 = new String(decodedBytes11);
                dec_str = "";
                decrypt_string(dw11);
                
                if (qw11 != null && dec_str.isEmpty() == false)
                	extr_ln = dec_str.substring(4);
                
                if (extr_ln.isEmpty() == false) {
                	while (extr_ln.charAt(extr_ln.length()-1) == 0) {
                		extr_ln = extr_ln.substring(0, extr_ln.length() - 1);  
                	}
                }
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return extr_ln;
    }
    
    public static void view_rec_from_flashcards() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Flashcards");
            JFrame remrec = new JFrame("View flashcard");
            JMenuBar rm = new JMenuBar();
            int nmb_of_r = number_of_recs("Triplets");
            String rcrds[][] = new String[nmb_of_r + 1][2];
            JComboBox records = new JComboBox();
            int n = 0;
            while (rs.next()) {
                rcrds[n][0] = (rs.getString("ID"));
                rcrds[n][1] = (get_words_from_triplet_by_id(rs.getString("Triplet1")) + ": " + get_language_from_triplet_by_id(rs.getString("Triplet1")) + ", " + get_language_from_triplet_by_id(rs.getString("Triplet2")) + ", " +  get_language_from_triplet_by_id(rs.getString("Triplet3")));
                dec_str = "";
                n++;
            }
            int m = 0;
            while (rcrds[m][0] != null) {
                m++;
            }
            for (int i = 0; i < m; i++) {
                records.addItem(rcrds[i][1]);
            }
            remrec.setJMenuBar(rm);
            rm.add(records);
            JButton rmv = new JButton("View");
            JButton cncl = new JButton("Cancel");
            rm.add(rmv);
            rm.add(cncl);
            rmv.setBackground(gclr);
            cncl.setBackground(button_backg_cl);
            rmv.setForeground(frclr);
            cncl.setForeground(black_cl);
            remrec.setSize(720, 68);
            remrec.setVisible(true);
            remrec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            rs.close();
            stmt.close();
            c.close();
            rmv.addActionListener(e -> {
            	disp_sel_flashcard(rcrds[records.getSelectedIndex()][0]);
                remrec.dispose();

            });
            cncl.addActionListener(e -> {
                remrec.dispose();

            });
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static void disp_sel_flashcard(String id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Flashcards WHERE ID = '" + id + "'");
            while (rs.next()) {
            	l1.setText(get_language_from_triplet_by_id(rs.getString("Triplet1")));
            	l2.setText(get_language_from_triplet_by_id(rs.getString("Triplet2")));
            	l3.setText(get_language_from_triplet_by_id(rs.getString("Triplet3")));
                w11.setText(get_word_from_triplet_by_id(rs.getString("Triplet1"), "Word1"));
                w21.setText(get_word_from_triplet_by_id(rs.getString("Triplet1"), "Word2"));
                w31.setText(get_word_from_triplet_by_id(rs.getString("Triplet1"), "Word3"));
                w12.setText(get_word_from_triplet_by_id(rs.getString("Triplet2"), "Word1"));
                w22.setText(get_word_from_triplet_by_id(rs.getString("Triplet2"), "Word2"));
                w32.setText(get_word_from_triplet_by_id(rs.getString("Triplet2"), "Word3"));
                w13.setText(get_word_from_triplet_by_id(rs.getString("Triplet3"), "Word1"));
                w23.setText(get_word_from_triplet_by_id(rs.getString("Triplet3"), "Word2"));
                w33.setText(get_word_from_triplet_by_id(rs.getString("Triplet3"), "Word3"));
                dec_str = "";
            }
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    public static String get_word_from_triplet_by_id(String id , String word) {
        Connection c = null;
        Statement stmt = null;
        String extr_word = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Triplets WHERE ID ='" + id + "'");
            while (rs.next()) {
            	extr_word = get_word_by_id(rs.getString(word));
                dec_str = "";
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return extr_word;
    }
    
    public static void view_rand_rec_from_flashcards() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Flashcards");
            int nmb_of_r = number_of_recs("Flashcards");
            String rcrds[] = new String[nmb_of_r + 1];
            int n = 0;
            while (rs.next()) {
                rcrds[n] = (rs.getString("ID"));
                n++;
            }
            rs.close();
            stmt.close();
            c.close();
            SecureRandom number = new SecureRandom();
            int rn = number.nextInt(n);
            disp_sel_flashcard(rcrds[rn]);
        } catch (Exception e) {
            JFrame f4 = new JFrame();
            JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return;
    }
    
    // The code below this line is responsible for the encryption and decryption of data
    
    public static String stf;
    public static String ck;
    public static String div;
    private static String SECRET_KEY = "";
    private static String SALTVALUE = "";
    public static String dec_str;
    public static String enc_str;
    
    private static byte[] iv = {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    };
    
    public static int Forward_S_Box[][] = {
        {
            0x63,
            0x7C,
            0x77,
            0x7B,
            0xF2,
            0x6B,
            0x6F,
            0xC5,
            0x30,
            0x01,
            0x67,
            0x2B,
            0xFE,
            0xD7,
            0xAB,
            0x76
        },
        {
            0xCA,
            0x82,
            0xC9,
            0x7D,
            0xFA,
            0x59,
            0x47,
            0xF0,
            0xAD,
            0xD4,
            0xA2,
            0xAF,
            0x9C,
            0xA4,
            0x72,
            0xC0
        },
        {
            0xB7,
            0xFD,
            0x93,
            0x26,
            0x36,
            0x3F,
            0xF7,
            0xCC,
            0x34,
            0xA5,
            0xE5,
            0xF1,
            0x71,
            0xD8,
            0x31,
            0x15
        },
        {
            0x04,
            0xC7,
            0x23,
            0xC3,
            0x18,
            0x96,
            0x05,
            0x9A,
            0x07,
            0x12,
            0x80,
            0xE2,
            0xEB,
            0x27,
            0xB2,
            0x75
        },
        {
            0x09,
            0x83,
            0x2C,
            0x1A,
            0x1B,
            0x6E,
            0x5A,
            0xA0,
            0x52,
            0x3B,
            0xD6,
            0xB3,
            0x29,
            0xE3,
            0x2F,
            0x84
        },
        {
            0x53,
            0xD1,
            0x00,
            0xED,
            0x20,
            0xFC,
            0xB1,
            0x5B,
            0x6A,
            0xCB,
            0xBE,
            0x39,
            0x4A,
            0x4C,
            0x58,
            0xCF
        },
        {
            0xD0,
            0xEF,
            0xAA,
            0xFB,
            0x43,
            0x4D,
            0x33,
            0x85,
            0x45,
            0xF9,
            0x02,
            0x7F,
            0x50,
            0x3C,
            0x9F,
            0xA8
        },
        {
            0x51,
            0xA3,
            0x40,
            0x8F,
            0x92,
            0x9D,
            0x38,
            0xF5,
            0xBC,
            0xB6,
            0xDA,
            0x21,
            0x10,
            0xFF,
            0xF3,
            0xD2
        },
        {
            0xCD,
            0x0C,
            0x13,
            0xEC,
            0x5F,
            0x97,
            0x44,
            0x17,
            0xC4,
            0xA7,
            0x7E,
            0x3D,
            0x64,
            0x5D,
            0x19,
            0x73
        },
        {
            0x60,
            0x81,
            0x4F,
            0xDC,
            0x22,
            0x2A,
            0x90,
            0x88,
            0x46,
            0xEE,
            0xB8,
            0x14,
            0xDE,
            0x5E,
            0x0B,
            0xDB
        },
        {
            0xE0,
            0x32,
            0x3A,
            0x0A,
            0x49,
            0x06,
            0x24,
            0x5C,
            0xC2,
            0xD3,
            0xAC,
            0x62,
            0x91,
            0x95,
            0xE4,
            0x79
        },
        {
            0xE7,
            0xC8,
            0x37,
            0x6D,
            0x8D,
            0xD5,
            0x4E,
            0xA9,
            0x6C,
            0x56,
            0xF4,
            0xEA,
            0x65,
            0x7A,
            0xAE,
            0x08
        },
        {
            0xBA,
            0x78,
            0x25,
            0x2E,
            0x1C,
            0xA6,
            0xB4,
            0xC6,
            0xE8,
            0xDD,
            0x74,
            0x1F,
            0x4B,
            0xBD,
            0x8B,
            0x8A
        },
        {
            0x70,
            0x3E,
            0xB5,
            0x66,
            0x48,
            0x03,
            0xF6,
            0x0E,
            0x61,
            0x35,
            0x57,
            0xB9,
            0x86,
            0xC1,
            0x1D,
            0x9E
        },
        {
            0xE1,
            0xF8,
            0x98,
            0x11,
            0x69,
            0xD9,
            0x8E,
            0x94,
            0x9B,
            0x1E,
            0x87,
            0xE9,
            0xCE,
            0x55,
            0x28,
            0xDF
        },
        {
            0x8C,
            0xA1,
            0x89,
            0x0D,
            0xBF,
            0xE6,
            0x42,
            0x68,
            0x41,
            0x99,
            0x2D,
            0x0F,
            0xB0,
            0x54,
            0xBB,
            0x16
        }
    };

    public static int Inv_S_Box[][] = {
        {
            0x52,
            0x09,
            0x6A,
            0xD5,
            0x30,
            0x36,
            0xA5,
            0x38,
            0xBF,
            0x40,
            0xA3,
            0x9E,
            0x81,
            0xF3,
            0xD7,
            0xFB
        },
        {
            0x7C,
            0xE3,
            0x39,
            0x82,
            0x9B,
            0x2F,
            0xFF,
            0x87,
            0x34,
            0x8E,
            0x43,
            0x44,
            0xC4,
            0xDE,
            0xE9,
            0xCB
        },
        {
            0x54,
            0x7B,
            0x94,
            0x32,
            0xA6,
            0xC2,
            0x23,
            0x3D,
            0xEE,
            0x4C,
            0x95,
            0x0B,
            0x42,
            0xFA,
            0xC3,
            0x4E
        },
        {
            0x08,
            0x2E,
            0xA1,
            0x66,
            0x28,
            0xD9,
            0x24,
            0xB2,
            0x76,
            0x5B,
            0xA2,
            0x49,
            0x6D,
            0x8B,
            0xD1,
            0x25
        },
        {
            0x72,
            0xF8,
            0xF6,
            0x64,
            0x86,
            0x68,
            0x98,
            0x16,
            0xD4,
            0xA4,
            0x5C,
            0xCC,
            0x5D,
            0x65,
            0xB6,
            0x92
        },
        {
            0x6C,
            0x70,
            0x48,
            0x50,
            0xFD,
            0xED,
            0xB9,
            0xDA,
            0x5E,
            0x15,
            0x46,
            0x57,
            0xA7,
            0x8D,
            0x9D,
            0x84
        },
        {
            0x90,
            0xD8,
            0xAB,
            0x00,
            0x8C,
            0xBC,
            0xD3,
            0x0A,
            0xF7,
            0xE4,
            0x58,
            0x05,
            0xB8,
            0xB3,
            0x45,
            0x06
        },
        {
            0xD0,
            0x2C,
            0x1E,
            0x8F,
            0xCA,
            0x3F,
            0x0F,
            0x02,
            0xC1,
            0xAF,
            0xBD,
            0x03,
            0x01,
            0x13,
            0x8A,
            0x6B
        },
        {
            0x3A,
            0x91,
            0x11,
            0x41,
            0x4F,
            0x67,
            0xDC,
            0xEA,
            0x97,
            0xF2,
            0xCF,
            0xCE,
            0xF0,
            0xB4,
            0xE6,
            0x73
        },
        {
            0x96,
            0xAC,
            0x74,
            0x22,
            0xE7,
            0xAD,
            0x35,
            0x85,
            0xE2,
            0xF9,
            0x37,
            0xE8,
            0x1C,
            0x75,
            0xDF,
            0x6E
        },
        {
            0x47,
            0xF1,
            0x1A,
            0x71,
            0x1D,
            0x29,
            0xC5,
            0x89,
            0x6F,
            0xB7,
            0x62,
            0x0E,
            0xAA,
            0x18,
            0xBE,
            0x1B
        },
        {
            0xFC,
            0x56,
            0x3E,
            0x4B,
            0xC6,
            0xD2,
            0x79,
            0x20,
            0x9A,
            0xDB,
            0xC0,
            0xFE,
            0x78,
            0xCD,
            0x5A,
            0xF4
        },
        {
            0x1F,
            0xDD,
            0xA8,
            0x33,
            0x88,
            0x07,
            0xC7,
            0x31,
            0xB1,
            0x12,
            0x10,
            0x59,
            0x27,
            0x80,
            0xEC,
            0x5F
        },
        {
            0x60,
            0x51,
            0x7F,
            0xA9,
            0x19,
            0xB5,
            0x4A,
            0x0D,
            0x2D,
            0xE5,
            0x7A,
            0x9F,
            0x93,
            0xC9,
            0x9C,
            0xEF
        },
        {
            0xA0,
            0xE0,
            0x3B,
            0x4D,
            0xAE,
            0x2A,
            0xF5,
            0xB0,
            0xC8,
            0xEB,
            0xBB,
            0x3C,
            0x83,
            0x53,
            0x99,
            0x61
        },
        {
            0x17,
            0x2B,
            0x04,
            0x7E,
            0xBA,
            0x77,
            0xD6,
            0x26,
            0xE1,
            0x69,
            0x14,
            0x63,
            0x55,
            0x21,
            0x0C,
            0x7D
        }
    };

    public static void disp_rec(String T) {
        dec_str += T;
    }

    static int split(char ct[], int i) {
        int res = 0;
        if (ct[i] != 0 && ct[i + 1] != 0)
            res = 16 * getNum(ct[i]) + getNum(ct[i + 1]);
        if (ct[i] != 0 && ct[i + 1] == 0)
            res = 16 * getNum(ct[i]);
        if (ct[i] == 0 && ct[i + 1] != 0)
            res = getNum(ct[i + 1]);
        if (ct[i] == 0 && ct[i + 1] == 0)
            res = 0;
        return res;
    }

    static int getNum(char ch) {
        int num = 0;
        if (ch >= '0' && ch <= '9') {
            num = ch - 0x30;
        } else {
            switch (ch) {
            case 'A':
            case 'a':
                num = 10;
                break;
            case 'B':
            case 'b':
                num = 11;
                break;
            case 'C':
            case 'c':
                num = 12;
                break;
            case 'D':
            case 'd':
                num = 13;
                break;
            case 'E':
            case 'e':
                num = 14;
                break;
            case 'F':
            case 'f':
                num = 15;
                break;
            default:
                num = 0;
            }
        }
        return num;
    }

    private static final byte[] IP = {
        58,
        50,
        42,
        34,
        26,
        18,
        10,
        2,
        60,
        52,
        44,
        36,
        28,
        20,
        12,
        4,
        62,
        54,
        46,
        38,
        30,
        22,
        14,
        6,
        64,
        56,
        48,
        40,
        32,
        24,
        16,
        8,
        57,
        49,
        41,
        33,
        25,
        17,
        9,
        1,
        59,
        51,
        43,
        35,
        27,
        19,
        11,
        3,
        61,
        53,
        45,
        37,
        29,
        21,
        13,
        5,
        63,
        55,
        47,
        39,
        31,
        23,
        15,
        7
    };

    private static final byte[] FP = {
        40,
        8,
        48,
        16,
        56,
        24,
        64,
        32,
        39,
        7,
        47,
        15,
        55,
        23,
        63,
        31,
        38,
        6,
        46,
        14,
        54,
        22,
        62,
        30,
        37,
        5,
        45,
        13,
        53,
        21,
        61,
        29,
        36,
        4,
        44,
        12,
        52,
        20,
        60,
        28,
        35,
        3,
        43,
        11,
        51,
        19,
        59,
        27,
        34,
        2,
        42,
        10,
        50,
        18,
        58,
        26,
        33,
        1,
        41,
        9,
        49,
        17,
        57,
        25
    };

    private static final byte[] E = {
        32,
        1,
        2,
        3,
        4,
        5,
        4,
        5,
        6,
        7,
        8,
        9,
        8,
        9,
        10,
        11,
        12,
        13,
        12,
        13,
        14,
        15,
        16,
        17,
        16,
        17,
        18,
        19,
        20,
        21,
        20,
        21,
        22,
        23,
        24,
        25,
        24,
        25,
        26,
        27,
        28,
        29,
        28,
        29,
        30,
        31,
        32,
        1
    };

    private static final byte[][] S = {
        {
            14,
            4,
            13,
            1,
            2,
            15,
            11,
            8,
            3,
            10,
            6,
            12,
            5,
            9,
            0,
            7,
            0,
            15,
            7,
            4,
            14,
            2,
            13,
            1,
            10,
            6,
            12,
            11,
            9,
            5,
            3,
            8,
            4,
            1,
            14,
            8,
            13,
            6,
            2,
            11,
            15,
            12,
            9,
            7,
            3,
            10,
            5,
            0,
            15,
            12,
            8,
            2,
            4,
            9,
            1,
            7,
            5,
            11,
            3,
            14,
            10,
            0,
            6,
            13
        },
        {
            15,
            1,
            8,
            14,
            6,
            11,
            3,
            4,
            9,
            7,
            2,
            13,
            12,
            0,
            5,
            10,
            3,
            13,
            4,
            7,
            15,
            2,
            8,
            14,
            12,
            0,
            1,
            10,
            6,
            9,
            11,
            5,
            0,
            14,
            7,
            11,
            10,
            4,
            13,
            1,
            5,
            8,
            12,
            6,
            9,
            3,
            2,
            15,
            13,
            8,
            10,
            1,
            3,
            15,
            4,
            2,
            11,
            6,
            7,
            12,
            0,
            5,
            14,
            9
        },
        {
            10,
            0,
            9,
            14,
            6,
            3,
            15,
            5,
            1,
            13,
            12,
            7,
            11,
            4,
            2,
            8,
            13,
            7,
            0,
            9,
            3,
            4,
            6,
            10,
            2,
            8,
            5,
            14,
            12,
            11,
            15,
            1,
            13,
            6,
            4,
            9,
            8,
            15,
            3,
            0,
            11,
            1,
            2,
            12,
            5,
            10,
            14,
            7,
            1,
            10,
            13,
            0,
            6,
            9,
            8,
            7,
            4,
            15,
            14,
            3,
            11,
            5,
            2,
            12
        },
        {
            7,
            13,
            14,
            3,
            0,
            6,
            9,
            10,
            1,
            2,
            8,
            5,
            11,
            12,
            4,
            15,
            13,
            8,
            11,
            5,
            6,
            15,
            0,
            3,
            4,
            7,
            2,
            12,
            1,
            10,
            14,
            9,
            10,
            6,
            9,
            0,
            12,
            11,
            7,
            13,
            15,
            1,
            3,
            14,
            5,
            2,
            8,
            4,
            3,
            15,
            0,
            6,
            10,
            1,
            13,
            8,
            9,
            4,
            5,
            11,
            12,
            7,
            2,
            14
        },
        {
            2,
            12,
            4,
            1,
            7,
            10,
            11,
            6,
            8,
            5,
            3,
            15,
            13,
            0,
            14,
            9,
            14,
            11,
            2,
            12,
            4,
            7,
            13,
            1,
            5,
            0,
            15,
            10,
            3,
            9,
            8,
            6,
            4,
            2,
            1,
            11,
            10,
            13,
            7,
            8,
            15,
            9,
            12,
            5,
            6,
            3,
            0,
            14,
            11,
            8,
            12,
            7,
            1,
            14,
            2,
            13,
            6,
            15,
            0,
            9,
            10,
            4,
            5,
            3
        },
        {
            12,
            1,
            10,
            15,
            9,
            2,
            6,
            8,
            0,
            13,
            3,
            4,
            14,
            7,
            5,
            11,
            10,
            15,
            4,
            2,
            7,
            12,
            9,
            5,
            6,
            1,
            13,
            14,
            0,
            11,
            3,
            8,
            9,
            14,
            15,
            5,
            2,
            8,
            12,
            3,
            7,
            0,
            4,
            10,
            1,
            13,
            11,
            6,
            4,
            3,
            2,
            12,
            9,
            5,
            15,
            10,
            11,
            14,
            1,
            7,
            6,
            0,
            8,
            13
        },
        {
            4,
            11,
            2,
            14,
            15,
            0,
            8,
            13,
            3,
            12,
            9,
            7,
            5,
            10,
            6,
            1,
            13,
            0,
            11,
            7,
            4,
            9,
            1,
            10,
            14,
            3,
            5,
            12,
            2,
            15,
            8,
            6,
            1,
            4,
            11,
            13,
            12,
            3,
            7,
            14,
            10,
            15,
            6,
            8,
            0,
            5,
            9,
            2,
            6,
            11,
            13,
            8,
            1,
            4,
            10,
            7,
            9,
            5,
            0,
            15,
            14,
            2,
            3,
            12
        },
        {
            13,
            2,
            8,
            4,
            6,
            15,
            11,
            1,
            10,
            9,
            3,
            14,
            5,
            0,
            12,
            7,
            1,
            15,
            13,
            8,
            10,
            3,
            7,
            4,
            12,
            5,
            6,
            11,
            0,
            14,
            9,
            2,
            7,
            11,
            4,
            1,
            9,
            12,
            14,
            2,
            0,
            6,
            10,
            13,
            15,
            3,
            5,
            8,
            2,
            1,
            14,
            7,
            4,
            10,
            8,
            13,
            15,
            12,
            9,
            0,
            3,
            5,
            6,
            11
        }
    };

    private static final byte[] P = {
        16,
        7,
        20,
        21,
        29,
        12,
        28,
        17,
        1,
        15,
        23,
        26,
        5,
        18,
        31,
        10,
        2,
        8,
        24,
        14,
        32,
        27,
        3,
        9,
        19,
        13,
        30,
        6,
        22,
        11,
        4,
        25
    };

    private static final byte[] PC1 = {
        57,
        49,
        41,
        33,
        25,
        17,
        9,
        1,
        58,
        50,
        42,
        34,
        26,
        18,
        10,
        2,
        59,
        51,
        43,
        35,
        27,
        19,
        11,
        3,
        60,
        52,
        44,
        36,
        63,
        55,
        47,
        39,
        31,
        23,
        15,
        7,
        62,
        54,
        46,
        38,
        30,
        22,
        14,
        6,
        61,
        53,
        45,
        37,
        29,
        21,
        13,
        5,
        28,
        20,
        12,
        4
    };

    private static final byte[] PC2 = {
        14,
        17,
        11,
        24,
        1,
        5,
        3,
        28,
        15,
        6,
        21,
        10,
        23,
        19,
        12,
        4,
        26,
        8,
        16,
        7,
        27,
        20,
        13,
        2,
        41,
        52,
        31,
        37,
        47,
        55,
        30,
        40,
        51,
        45,
        33,
        48,
        44,
        49,
        39,
        56,
        34,
        53,
        46,
        42,
        50,
        36,
        29,
        32
    };

    private static final byte[] rotations = {
        1,
        1,
        2,
        2,
        2,
        2,
        2,
        2,
        1,
        2,
        2,
        2,
        2,
        2,
        2,
        1
    };

    private static long IP(long src) {
        return permute(IP, 64, src);
    } // 64-bit output

    private static long FP(long src) {
        return permute(FP, 64, src);
    } // 64-bit output

    private static long E(int src) {
        return permute(E, 32, src & 0xFFFFFFFFL);
    } // 48-bit output

    private static int P(int src) {
        return (int) permute(P, 32, src & 0xFFFFFFFFL);
    } // 32-bit output

    private static long PC1(long src) {
        return permute(PC1, 64, src);
    } // 56-bit output

    private static long PC2(long src) {
        return permute(PC2, 56, src);
    } // 48-bit output

    private static long permute(byte[] table, int srcWidth, long src) {
        long dst = 0;
        for (int i = 0; i < table.length; i++) {
            int srcPos = srcWidth - table[i];
            dst = (dst << 1) | (src >> srcPos & 0x01);
        }
        return dst;
    }

    private static byte S(int boxNumber, byte src) {
        // The first aindex based on the following bit shuffle:
        // abcdef => afbcde
        src = (byte)(src & 0x20 | ((src & 0x01) << 4) | ((src & 0x1E) >> 1));
        return S[boxNumber - 1][src];
    }

    private static long getLongFromBytes(byte[] ba, int offset) {
        long l = 0;
        for (int i = 0; i < 8; i++) {
            byte value;
            if ((offset + i) < ba.length) {
                // and last bits determine which 16-value row to
                // reference, so we transform the 6-bit input into an
                // absolute
                value = ba[offset + i];
            } else {
                value = 0;
            }
            l = l << 8 | (value & 0xFFL);
        }
        return l;
    }

    private static void getBytesFromLong(byte[] ba, int offset, long l) {
        for (int i = 7; i > -1; i--) {
            if ((offset + i) < ba.length) {
                ba[offset + i] = (byte)(l & 0xFF);
                l = l >> 8;
            } else {
                break;
            }
        }
    }

    private static int feistel(int r, /* 48 bits */ long subkey) {
        // 1. expansion
        long e = E(r);
        // 2. key mixing
        long x = e ^ subkey;
        // 3. substitution
        int dst = 0;
        for (int i = 0; i < 8; i++) {
            dst >>>= 4;
            int s = S(8 - i, (byte)(x & 0x3F));
            dst |= s << 28;
            x >>= 6;
        }
        // 4. permutation
        return P(dst);
    }

    private static long[] createSubkeys( /* 64 bits */ long key) {
        long subkeys[] = new long[16];

        // perform the PC1 permutation
        key = PC1(key);

        // split into 28-bit left and right (c and d) pairs.
        int c = (int)(key >> 28);
        int d = (int)(key & 0x0FFFFFFF);

        // for each of the 16 needed subkeys, perform a bit
        // rotation on each 28-bit keystuff half, then join
        // the halves together and permute to generate the
        // subkey.
        for (int i = 0; i < 16; i++) {
            // rotate the 28-bit values
            if (rotations[i] == 1) {
                // rotate by 1 bit
                c = ((c << 1) & 0x0FFFFFFF) | (c >> 27);
                d = ((d << 1) & 0x0FFFFFFF) | (d >> 27);
            } else {
                // rotate by 2 bits
                c = ((c << 2) & 0x0FFFFFFF) | (c >> 26);
                d = ((d << 2) & 0x0FFFFFFF) | (d >> 26);
            }

            // join the two keystuff halves together.
            long cd = (c & 0xFFFFFFFFL) << 28 | (d & 0xFFFFFFFFL);

            // perform the PC2 permutation
            subkeys[i] = PC2(cd);
        }

        return subkeys; /* 48-bit values */
    }

    public static long encryptBlock(long m, /* 64 bits */ long key) {
        // generate the 16 subkeys
        long subkeys[] = createSubkeys(key);

        // perform the initial permutation
        long ip = IP(m);

        // split the 32-bit value into 16-bit left and right halves.
        int l = (int)(ip >> 32);
        int r = (int)(ip & 0xFFFFFFFFL);

        // perform 16 rounds
        for (int i = 0; i < 16; i++) {
            int previous_l = l;
            // the right half becomes the new left half.
            l = r;
            // the Feistel function is applied to the old left half
            // and the resulting value is stored in the right half.
            r = previous_l ^ feistel(r, subkeys[i]);
        }

        // reverse the two 32-bit segments (left to right; right to left)
        long rl = (r & 0xFFFFFFFFL) << 32 | (l & 0xFFFFFFFFL);

        // apply the final permutation
        long fp = FP(rl);

        // return the ciphertext
        return fp;
    }

    public static void encryptBlock(
        byte[] message,
        int messageOffset,
        byte[] ciphertext,
        int ciphertextOffset,
        byte[] key
    ) {
        long m = getLongFromBytes(message, messageOffset);
        long k = getLongFromBytes(key, 0);
        long c = encryptBlock(m, k);
        getBytesFromLong(ciphertext, ciphertextOffset, c);
    }

    public static byte[] encrypt(byte[] message, byte[] key) {
        byte[] ciphertext = new byte[message.length];

        // encrypt each 8-byte (64-bit) block of the message.
        for (int i = 0; i < message.length; i += 8) {
            encryptBlock(message, i, ciphertext, i, key);
        }

        return ciphertext;
    }

    public static byte[] encrypt(byte[] challenge, String password) {
        return encrypt(challenge, passwordToKey(password));
    }

    private static byte[] passwordToKey(String password) {
        byte[] pwbytes = password.getBytes();
        byte[] key = new byte[8];
        for (int i = 0; i < 8; i++) {
            if (i < pwbytes.length) {
                byte b = pwbytes[i];
                // flip the byte
                byte b2 = 0;
                for (int j = 0; j < 8; j++) {
                    b2 <<= 1;
                    b2 |= (b & 0x01);
                    b >>>= 1;
                }
                key[i] = b2;
            } else {
                key[i] = 0;
            }
        }
        return key;
    }

    private static int charToNibble(char c) {
        if (c >= '0' && c <= '9') {
            return (c - '0');
        } else if (c >= 'a' && c <= 'f') {
            return (10 + c - 'a');
        } else if (c >= 'A' && c <= 'F') {
            return (10 + c - 'A');
        } else {
            return 0;
        }
    }

    private static byte[] parseBytes(String s) {
        s = s.replace(" ", "");
        byte[] ba = new byte[s.length() / 2];
        if (s.length() % 2 > 0) {
            s = s + '0';
        }
        for (int i = 0; i < s.length(); i += 2) {
            ba[i / 2] = (byte)(charToNibble(s.charAt(i)) << 4 | charToNibble(s.charAt(i + 1)));
        }
        return ba;
    }

    private static String hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X ", bytes[i]));
        }
        return sb.toString();
    }

    private static long IV;

    public static long getIv() {
        return IV;
    }

    public static void setIv(long iv) {
        IV = iv;
    }

    public static byte[] encryptCBC(byte[] message, byte[] key) {
        byte[] ciphertext = new byte[message.length];
        long k = getLongFromBytes(key, 0);
        long previousCipherBlock = IV;

        for (int i = 0; i < message.length; i += 8) {
            // get the message block to be encrypted (8bytes = 64bits)
            long messageBlock = getLongFromBytes(message, i);

            // XOR message block with previous cipherblock and encrypt
            // First previousCiphertext = Initial Vector (IV)
            long cipherBlock = encryptBlock(messageBlock ^ previousCipherBlock, k);

            // Store the cipherBlock in the correct position in ciphertext
            getBytesFromLong(ciphertext, i, cipherBlock);

            // Update previousCipherBlock
            previousCipherBlock = cipherBlock;
        }

        return ciphertext;
    }

    public static long decryptBlock(long c, /* 64 bits */ long key) {
        // generate the 16 subkeys
        long[] subkeys = createSubkeys(key);

        // perform the initial permutation
        long ip = IP(c);

        // split the 32-bit value into 16-bit left and right halves.
        int l = (int)(ip >> 32);
        int r = (int)(ip & 0xFFFFFFFFL);

        // perform 16 rounds
        // NOTE: reverse order of subkeys used!
        for (int i = 15; i > -1; i--) {
            int previous_l = l;
            // the right half becomes the new left half.
            l = r;
            // the Feistel function is applied to the old left half
            // and the resulting value is stored in the right half.
            r = previous_l ^ feistel(r, subkeys[i]);
        }

        // reverse the two 32-bit segments (left to right; right to left)
        long rl = (r & 0xFFFFFFFFL) << 32 | (l & 0xFFFFFFFFL);

        // apply the final permutation
        long fp = FP(rl);

        // return the message
        return fp;
    }

    public static void decryptBlock(
        byte[] ciphertext,
        int ciphertextOffset,
        byte[] message,
        int messageOffset,
        byte[] key
    ) {
        long c = getLongFromBytes(ciphertext, ciphertextOffset);
        long k = getLongFromBytes(key, 0);
        long m = decryptBlock(c, k);
        getBytesFromLong(message, messageOffset, m);
    }

    public static byte[] decrypt(byte[] ciphertext, byte[] key) {
        byte[] message = new byte[ciphertext.length];

        // encrypt each 8-byte (64-bit) block of the message.
        for (int i = 0; i < ciphertext.length; i += 8) {
            decryptBlock(ciphertext, i, message, i, key);
        }

        return message;
    }

    public static byte[] decryptCBC(byte[] ciphertext, byte[] key) {
        byte[] message = new byte[ciphertext.length];
        long k = getLongFromBytes(key, 0);
        long previousCipherBlock = IV;

        for (int i = 0; i < ciphertext.length; i += 8) {
            // get the cipher block to be decrypted (8bytes = 64bits)
            long cipherBlock = getLongFromBytes(ciphertext, i);

            // Decrypt the cipher block and XOR with previousCipherBlock
            // First previousCiphertext = Initial Vector (IV)
            long messageBlock = decryptBlock(cipherBlock, k);
            messageBlock = messageBlock ^ previousCipherBlock;

            // Store the messageBlock in the correct position in message
            getBytesFromLong(message, i, messageBlock);

            // Update previousCipherBlock
            previousCipherBlock = cipherBlock;
        }

        return message;
    }

    public static void ctostr(char[] vrbls, int pos) {
        String tf = "";
        for (int i = 0; i < 8; i++) {
            tf += vrbls[i + pos];
        }
        SecureRandom number = new SecureRandom();
        for (int i = 0; i < 4; i++) {
            String r = "";
            r += number.nextInt(256);
            Integer inv = Integer.valueOf(r);
            tf += String.format("%02x", inv);
        }

        //System.out.println(tf);
        String key = ck;
        byte[] enc = encrypt(parseBytes(tf), parseBytes(key));
        for (int i = 0; i < 8; i++) {
            stf += String.format("%02x", enc[i]);
        }

    }

    private static void dec_str(char[] tdec, int pos) {
        String tf = "";
        for (int i = 0; i < 16; i++) {
            tf += tdec[i + pos];
        }
        //System.out.println(tf);
        String key = ck;
        byte[] dec_t = decrypt(parseBytes(tf), parseBytes(key));
        String tsb = "";
        //System.out.println("\tDecrypted: " + hex(dec)); 
        for (int i = 0; i < 4; i++) {
            tsb += String.format("%02x", dec_t[i]);
        }
        //System.out.println(tsb); 
        String ir1 = "";
        char[] chtd = tsb.toCharArray();
        for (int i = 0; i < 8; i += 2) {
            int fs = getNum(chtd[i]);
            int ss = getNum(chtd[i + 1]);
            Integer intObject = Integer.valueOf(Inv_S_Box[fs][ss]);
            String cv = "";
            cv += (String.format("%02x", intObject));
            //System.out.println(cv);
            int rc = Integer.valueOf(cv, 16);
            //System.out.println(rc);
            
            if (rc == 128){
            	ir1 += "ק";
            }
            else if (rc == 129){
            	ir1 += "ר";
            }
            else if (rc == 130){
            	ir1 += "א";
            }
            else if (rc == 131){
            	ir1 += "ט";
            }
            else if (rc == 132){
            	ir1 += "ו";
            }
            else if (rc == 133){
            	ir1 += "ן";
            }
            else if (rc == 134){
            	ir1 += "ם";
            }
            else if (rc == 135){
            	ir1 += "פ";
            }
            else if (rc == 136){
            	ir1 += "ש";
            }
            else if (rc == 137){
            	ir1 += "ד";
            }
            else if (rc == 138){
            	ir1 += "ג";
            }
            else if (rc == 139){
            	ir1 += "כ";
            }
            else if (rc == 140){
            	ir1 += "ע";
            }
            else if (rc == 141){
            	ir1 += "י";
            }
            else if (rc == 142){
            	ir1 += "ח";
            }
            else if (rc == 143){
            	ir1 += "ל";
            }
            else if (rc == 144){
            	ir1 += "ך";
            }
            else if (rc == 145){
            	ir1 += "ף";
            }
            else if (rc == 146){
            	ir1 += "ז";
            }
            else if (rc == 147){
            	ir1 += "ס";
            }
            else if (rc == 148){
            	ir1 += "ב";
            }
            else if (rc == 149){
            	ir1 += "ה";
            }
            else if (rc == 150){
            	ir1 += "נ";
            }
            else if (rc == 151){
            	ir1 += "מ";
            }
            else if (rc == 152){
            	ir1 += "צ";
            }
            else if (rc == 153){
            	ir1 += "ת";
            }
            else if (rc == 154){
            	ir1 += "ץ";
            }
	        if (rc < 128 || rc > 154) {
	        	char ctp = (char) rc;
	        	ir1 += ctp;
	        }
        }
        disp_rec(ir1);

    }

    private static void dec_ivs(char[] tdec, int pos) {
        String tf = "";
        for (int i = 0; i < 16; i++) {
            tf += tdec[i + pos];
        }
        //System.out.println(tf);
        String key = ck;
        byte[] dec_t = decrypt(parseBytes(tf), parseBytes(key));
        String tsb = "";
        //System.out.println("\tDecrypted: " + hex(dec)); 
        for (int i = 0; i < 4; i++) {
            tsb += String.format("%02x", dec_t[i]);
        }
        //System.out.println(tsb); 
        String ir = "";
        char[] chtd = tsb.toCharArray();
        for (int i = 0; i < 8; i += 2) {
            int fs = getNum(chtd[i]);
            int ss = getNum(chtd[i + 1]);
            Integer intObject = Integer.valueOf(Inv_S_Box[fs][ss]);
            String cv = "";
            cv += (String.format("%02x", intObject));
            //System.out.println(cv);
            int rc = Integer.valueOf(cv, 16);
            //System.out.println(rc);
            char ctp = (char) rc;
            ir += ctp;
        }
        div += ir;
    }

    public static String encrypt_AES(String strToEncrypt) {
        try {
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            /* Create factory for secret keys. */
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            /* PBEKeySpec class implements KeySpec interface. */
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALTVALUE.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            /* Retruns encrypted value. */
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error occured during encryption: " + e.toString());
        }
        return null;
    }

    public static String decrypt_AES(String strToDecrypt) {
        try {
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            /* Create factory for secret keys. */
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            /* PBEKeySpec class implements KeySpec interface. */
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALTVALUE.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            /* Retruns decrypted value. */
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error occured during decryption: " + e.toString());
        }
        return null;
    }

    public static void encrypt_string(String str1) {
        stf = "";
        try {
            StringBuilder ivst = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                ivst.append(iv[i]);
                if (i < 15)
                    ivst.append(",");
            }
            //System.out.println(ivst.toString());
            String ir = "";
            String str = ivst.toString();
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if ((int) ch[i] != 0) {
                    int b = ((int) ch[i]) / 16;
                    int s = ((int) ch[i]) % 16;
                    Integer intObject = Integer.valueOf(Forward_S_Box[b][s]);
                    ir += (String.format("%02x", intObject));
                } else {
                    Integer c = Integer.valueOf(Forward_S_Box[0][0]);
                    ir += (String.format("%02x", c));
                }

            }
            while (ir.length() % 8 != 0) {
                ir += "63";
            }
            //System.out.println(ir);
            //System.out.println("Length of a String is: " + ir.length());
            char[] iarr = new char[ir.length()];

            // Copy character by character into array
            for (int i = 0; i < ir.length(); i++) {
                iarr[i] = ir.charAt(i);
                //System.out.println(iarr[i]);
            }

            // Printing content of array
            /*for (char c : iarr) {
                System.out.println(c);
            }
            */
            int al = iarr.length;
            int curr = 0;
            while (curr < al) {
                ctostr(iarr, curr);
                curr += 8;
            }
            String eiv = stf;
            stf = "";
            String ir2 = "";
            String str2 = SALTVALUE;
            char[] ch2 = str2.toCharArray();
            for (int i = 0; i < ch2.length; i++) {
                if ((int) ch2[i] != 0) {
                    int b = ((int) ch2[i]) / 16;
                    int s = ((int) ch2[i]) % 16;
                    Integer intObject = Integer.valueOf(Forward_S_Box[b][s]);
                    ir2 += (String.format("%02x", intObject));
                } else {
                    Integer c = Integer.valueOf(Forward_S_Box[0][0]);
                    ir2 += (String.format("%02x", c));
                }

            }
            while (ir2.length() % 8 != 0) {
                ir2 += "63";
            }
            //System.out.println(ir);
            //System.out.println("Length of a String is: " + ir.length());
            char[] iarr2 = new char[ir2.length()];

            // Copy character by character into array
            for (int i = 0; i < ir2.length(); i++) {
                iarr2[i] = ir2.charAt(i);
                //System.out.println(iarr[i]);
            }

            // Printing content of array
            /*for (char c : iarr) {
                System.out.println(c);
            }
            */
            int al2 = iarr2.length;
            int curr2 = 0;
            while (curr2 < al2) {
                ctostr(iarr2, curr2);
                curr2 += 8;
            }
            String enc_slt = stf;
            stf = "";
            String ir1 = "";
            char[] ch1 = str1.toCharArray();
            for (int i = 0; i < ch1.length; i++) {
                if ((int) ch1[i] != 0) {
                    int b = ((int) ch1[i]) / 16;
                    int s = ((int) ch1[i]) % 16;
                    Integer intObject = Integer.valueOf(Forward_S_Box[b][s]);
                    ir1 += (String.format("%02x", intObject));
                } else {
                    Integer c = Integer.valueOf(Forward_S_Box[0][0]);
                    ir1 += (String.format("%02x", c));
                }

            }
            while (ir1.length() % 8 != 0) {
                ir1 += "63";
            }
            //System.out.println(ir);
            //System.out.println("Length of a String is: " + ir.length());
            char[] iarr1 = new char[ir1.length()];

            // Copy character by character into array
            for (int i = 0; i < ir1.length(); i++) {
                iarr1[i] = ir1.charAt(i);
                //System.out.println(iarr[i]);
            }

            // Printing content of array
            /*for (char c : iarr) {
                System.out.println(c);
            }
            */
            int al1 = iarr1.length;
            int curr1 = 0;
            while (curr1 < al1) {
                ctostr(iarr1, curr1);
                curr1 += 8;
            }
            SecureRandom numb1 = new SecureRandom();
            for (int i = 0; i < 16; i++) {
                iv[i] = (byte) numb1.nextInt(256);
            }
            enc_str = (eiv + "," + enc_slt + "," + encrypt_AES(stf));
        } catch (Exception q) {
            System.out.println("An error occurred.");
            q.printStackTrace();
        }
    }

    public static void decrypt_string(String result) {

        // Display selected file in console
        //System.out.println(selectedFile.getAbsolutePath());
        try {
            String[] prts = result.split(",");
            div = "";
            char[] tdec0 = prts[0].toCharArray();
            int td_len0 = tdec0.length;
            int crr0 = 0;
            while (crr0 < td_len0) {
                dec_ivs(tdec0, crr0);
                crr0 += 16;
            }
            //System.out.println(div);
            for (int i = 0; i < div.length(); i++) {
                if (div.charAt(i) < '!') {
                    div = div.substring(0, i) + div.substring(i + 1);
                    i--;
                }
            }
            /*
            char[] test = div.toCharArray();
            for (int i = 0; i < test.length; i++) {
              System.out.println((int) test[i]);
            }
            */
            String[] ivs = div.split(",");
            div = "";
            for (int i = 0; i < 16; i++) {
                Integer q = Integer.parseInt(ivs[i]);
                iv[i] = q.byteValue();
            }
            /*
            for (int i = 0; i< 16; i++) {
              System.out.println(iv[i]);
            }
            */
            div = "";
            char[] tdec2 = prts[1].toCharArray();
            int td_len2 = tdec2.length;
            int crr2 = 0;
            while (crr2 < td_len2) {
                dec_ivs(tdec2, crr2);
                crr2 += 16;
            }
            SALTVALUE = div;
            div = "";
            //System.out.println(prts[1]);

            char[] tdec1 = decrypt_AES(prts[2]).toCharArray();
            int td_len1 = tdec1.length;
            int crr1 = 0;
            while (crr1 < td_len1) {
                dec_str(tdec1, crr1);
                crr1 += 16;
            }

        } catch (Exception r) {
            System.out.println("An error occurred.");
            r.printStackTrace();
        }
    }

    public static void set_salt_and_iv() {
    	StringBuilder slt = new StringBuilder();
        SecureRandom number = new SecureRandom();
        for (int i = 0; i < 64; i++) {
        slt.append((char)(65 + (number.nextInt(26))));
        }
        SALTVALUE = slt.toString();
        SecureRandom numb = new SecureRandom();
        for (int i = 0; i < 16; i++) {
          iv[i]= (byte) numb.nextInt(256); 
        }
    }

    // The end of the code that's responsible for the encryption and decryption of data
}

class Worderize {

    public static void main(String[] args) throws Exception {
        Worderize_main.create_tables();
        Worderize_main.set_salt_and_iv();
        Worderize_main.crfl();
        Worderize_main worderize_app = new Worderize_main();
        Worderize_main.imp_setttings();
    }
}

class Hebrew_keyboard extends JFrame implements ActionListener {
	
	static Color back_grey_cl = new Color(27, 29, 29);
	static Color forg_blue_cl = new Color(77, 198, 232);
	static Color forg_red_cl = new Color(255, 103, 79);
	static Color forg_white_cl = new Color(239, 239, 239);
	StringBuilder str_to_be_disp = new StringBuilder();
	StringBuilder str_to_be_encr = new StringBuilder();
	JLabel disp_text = new JLabel("", SwingConstants.RIGHT);
	JTextPane txpane = new JTextPane();
	
	private static void customize_button(JButton btn) {
		btn.setBackground(back_grey_cl);
	      btn.setForeground(forg_blue_cl);
		  Border line = new LineBorder(forg_blue_cl);
		  Border margin = new EmptyBorder(5, 15, 5, 15);
		  Border compound = new CompoundBorder(line, margin);
		  btn.setBorder(compound);
		}
	
	private static void customize_erase_button(JButton btn) {
		btn.setBackground(back_grey_cl);
	      btn.setForeground(forg_red_cl);
		  Border line = new LineBorder(forg_red_cl);
		  Border margin = new EmptyBorder(5, 15, 5, 15);
		  Border compound = new CompoundBorder(line, margin);
		  btn.setBorder(compound);
		}
	
	private static void customize_space_button(JButton btn) {
		btn.setBackground(back_grey_cl);
	      btn.setForeground(forg_white_cl);
		  Border line = new LineBorder(forg_white_cl);
		  Border margin = new EmptyBorder(5, 15, 5, 15);
		  Border compound = new CompoundBorder(line, margin);
		  btn.setBorder(compound);
		}
	
	    Container container=getContentPane();
	    
	    JButton Add_button = new JButton("Add");
	    JButton Cancel_button = new JButton("Cancel");
	    
	    JButton space_button = new JButton("");
	    
	    JButton Qof_button = new JButton("ק");
	    JButton Resh_button = new JButton("ר");
	    JButton Alef_button = new JButton("א");
	    JButton Tet_button = new JButton("ט");
	    JButton Vav_button = new JButton("ו");
	    JButton Nun_end_button = new JButton("ן");
	    JButton Mem_end_button = new JButton("ם");
	    JButton Pef_button = new JButton("פ");
	    JButton erase_to_right_button = new JButton("⌦");
	    
	    JButton Shin_button = new JButton("ש");
	    JButton Dalet_button = new JButton("ד");
	    JButton Gimel_button = new JButton("ג");
	    JButton Kaf_button = new JButton("כ");
	    JButton Ayin_button = new JButton("ע");
	    JButton Yud_button = new JButton("י");
	    JButton Ches_button = new JButton("ח");
	    JButton Lamed_button = new JButton("ל");
	    JButton Chaf_end_button = new JButton("ך");
	    JButton Pay_end_button = new JButton("ף");
	    
	    JButton Zayin_button = new JButton("ז");
	    JButton Samach_button = new JButton("ס");
	    JButton Veis_button = new JButton("ב");
	    JButton Hay_button = new JButton("ה");
	    JButton Nun_button = new JButton("נ");
	    JButton Mem_button = new JButton("מ");
	    JButton Tsadeh_button = new JButton("צ");
	    JButton Tav_button = new JButton("ת");
	    JButton Tsadeh_end_button = new JButton("ץ");
	 
	    Hebrew_keyboard()
	    {
	        setLayoutManager();
	        setLocationAndSize();
	        addComponentsToContainer();
	        addActionEvent();//calling addActionEvent() method
	 
	    }
	   public void setLayoutManager()
	   {
	       container.setLayout(null);
	   }
	   public void setLocationAndSize()
	   {
		   int lby = 310;
		   disp_text.setText("מילה" + ": ");
		   space_button.setBounds(105,140 + lby,300,40);
		   disp_text.setForeground(forg_white_cl);
		   
		   Qof_button.setBounds(35,10 + lby,50,40);
		   Resh_button.setBounds(85,10 + lby,50,40);
		   Alef_button.setBounds(135,10 + lby,50,40);
		   Tet_button.setBounds(185,10 + lby,50,40);
		   Vav_button.setBounds(235,10 + lby,50,40);
		   Nun_end_button.setBounds(285,10 + lby,50,40);
		   Mem_end_button.setBounds(335,10 + lby,50,40);
		   Pef_button.setBounds(385,10 + lby,50,40);
		   erase_to_right_button.setBounds(435,10 + lby,50,40);

		   Shin_button.setBounds(10,50 + lby,50,40);
		   Dalet_button.setBounds(60,50 + lby,50,40);
		   Gimel_button.setBounds(110,50 + lby,50,40);
		   Kaf_button.setBounds(160,50 + lby,50,40);
		   Ayin_button.setBounds(210,50 + lby,50,40);
		   Yud_button.setBounds(260,50 + lby,50,40);
		   Ches_button.setBounds(310,50 + lby,50,40);
		   Lamed_button.setBounds(360,50 + lby,50,40);
		   Chaf_end_button.setBounds(410,50 + lby,50,40);
		   Pay_end_button.setBounds(460,50 + lby,50,40);
		   
		   Zayin_button.setBounds(35,90 + lby,50,40);
		   Samach_button.setBounds(85,90 + lby,50,40);
		   Veis_button.setBounds(135,90 + lby,50,40);
		   Hay_button.setBounds(185,90 + lby,50,40);
		   Nun_button.setBounds(235,90 + lby,50,40);
		   Mem_button.setBounds(285,90 + lby,50,40);
		   Tsadeh_button.setBounds(335,90 + lby,50,40);
		   Tav_button.setBounds(385,90 + lby,50,40);
		   Tsadeh_end_button.setBounds(435,90 + lby,50,40);
		   
		   Add_button.setBounds(300,200 + lby,100,40);
		   Cancel_button.setBounds(410,200 + lby,100,40);
		   
		   txpane.setBounds(10,55,500,250);
		   
		   disp_text.setBounds(35,10,450,40);
	 
	   }
	   public void addComponentsToContainer()
	   {
		   disp_text.setFont(new Font("Arial", Font.PLAIN, 30));
		   txpane.setFont(new Font("Arial", Font.PLAIN, 30));
		   txpane.setText("Enter the Definition...");
		   txpane.setBackground(new Color (48, 47, 45));
		   txpane.setForeground(forg_blue_cl);
		   txpane.setCaretColor(forg_white_cl);

		   container.setBackground(back_grey_cl);
	       container.add(space_button);
	       container.add(disp_text);
	       
		   container.add(Qof_button);
	       container.add(Resh_button);
	       container.add(Alef_button);
	       container.add(Tet_button);
	       container.add(Vav_button);
	       container.add(Nun_end_button);
	       container.add(Mem_end_button);
	       container.add(Pef_button);
	       container.add(erase_to_right_button);
	       
	       container.add(Shin_button);
	       container.add(Dalet_button);
	       container.add(Gimel_button);
	       container.add(Kaf_button);
	       container.add(Ayin_button);
	       container.add(Yud_button);
	       container.add(Ches_button);
	       container.add(Lamed_button);
	       container.add(Chaf_end_button);
	       container.add(Pay_end_button);
	       
	       container.add(Zayin_button);
	       container.add(Samach_button);
	       container.add(Veis_button);
	       container.add(Hay_button);
	       container.add(Nun_button);
	       container.add(Mem_button);
	       container.add(Tsadeh_button);
	       container.add(Tav_button);
	       container.add(Tsadeh_end_button);
	       
	       container.add(Add_button);
	       container.add(Cancel_button);
	       container.add(txpane);
	       
	       container.setBackground(back_grey_cl);
	       customize_button(Add_button);
	       customize_erase_button(Cancel_button);
	       
	       customize_space_button(space_button);
	       customize_button(Qof_button);
	       customize_button(Resh_button);
	       customize_button(Alef_button);
	       customize_button(Tet_button);
	       customize_button(Vav_button);
	       customize_button(Nun_end_button);
	       customize_button(Mem_end_button);
	       customize_button(Pef_button);
	       customize_erase_button(erase_to_right_button);

	       customize_button(Shin_button);
	       customize_button(Dalet_button);
	       customize_button(Gimel_button);
	       customize_button(Kaf_button);
	       customize_button(Ayin_button);
	       customize_button(Yud_button);
	       customize_button(Ches_button);
	       customize_button(Lamed_button);
	       customize_button(Chaf_end_button);
	       customize_button(Pay_end_button);
	       
	       customize_button(Zayin_button);
	       customize_button(Samach_button);
	       customize_button(Veis_button);
	       customize_button(Hay_button);
	       customize_button(Nun_button);
	       customize_button(Mem_button);
	       customize_button(Tsadeh_button);
	       customize_button(Tav_button);
	       customize_button(Tsadeh_end_button);
	   }
	   public void addActionEvent()
	   {
		   Add_button.addActionListener(this);
		   Cancel_button.addActionListener(this);
		   
		   Qof_button.addActionListener(this);
		   Resh_button.addActionListener(this);
		   Alef_button.addActionListener(this);
		   Tet_button.addActionListener(this);
		   Vav_button.addActionListener(this);
		   Nun_end_button.addActionListener(this);
		   Mem_end_button.addActionListener(this);
		   Pef_button.addActionListener(this);
		   erase_to_right_button.addActionListener(this);
		   Shin_button.addActionListener(this);
		   Dalet_button.addActionListener(this);
		   Gimel_button.addActionListener(this);
		   Kaf_button.addActionListener(this);
		   Ayin_button.addActionListener(this);
		   Yud_button.addActionListener(this);
		   Ches_button.addActionListener(this);
		   Lamed_button.addActionListener(this);
		   Chaf_end_button.addActionListener(this);
		   Pay_end_button.addActionListener(this);
		   Zayin_button.addActionListener(this);
		   Samach_button.addActionListener(this);
		   Veis_button.addActionListener(this);
		   Hay_button.addActionListener(this);
		   Nun_button.addActionListener(this);
		   Mem_button.addActionListener(this);
		   Tsadeh_button.addActionListener(this);
		   Tav_button.addActionListener(this);
		   Tsadeh_end_button.addActionListener(this);
		   space_button.addActionListener(this);
	   }
	 
	 
	   @Override
	    public void actionPerformed(ActionEvent e) {
		   
		   if (e.getSource() == space_button) {
	        	str_to_be_disp.insert(0, " ");
	        	str_to_be_encr.append((char)32);
	        }
		   
	        if (e.getSource() == Qof_button) {
	        	str_to_be_disp.insert(0, "ק");
	        	str_to_be_encr.append((char)128);
	        }
	        
	        if (e.getSource() == Resh_button) {
	        	str_to_be_disp.insert(0, "ר");
	        	str_to_be_encr.append((char)129);
	        }
	        
	        if (e.getSource() == Alef_button) {
	        	str_to_be_disp.insert(0, "א");
	        	str_to_be_encr.append((char)130);
	        }
		    
	        if (e.getSource() == Tet_button) {
	        	str_to_be_disp.insert(0, "ט");
	        	str_to_be_encr.append((char)131);
	        }
	        
	        if (e.getSource() == Vav_button) {
	        	str_to_be_disp.insert(0, "ו");
	        	str_to_be_encr.append((char)132);
	        }
	        
	        if (e.getSource() == Nun_end_button) {
	        	str_to_be_disp.insert(0, "ן");
	        	str_to_be_encr.append((char)133);
	        }
	        
	        if (e.getSource() == Mem_end_button) {
	        	str_to_be_disp.insert(0, "ם");
	        	str_to_be_encr.append((char)134);
	        }
	        
	        if (e.getSource() == Pef_button) {
	        	str_to_be_disp.insert(0, "פ");
	        	str_to_be_encr.append((char)135);
	        }
	        
	        if (e.getSource() == erase_to_right_button) {
	        	if (str_to_be_disp.length() > 0) {
	        		str_to_be_disp.deleteCharAt(0);
	        		str_to_be_encr.setLength(str_to_be_encr.length() - 1);
	        	}
	        }

	        if (e.getSource() == Shin_button) {
	        	str_to_be_disp.insert(0, "ש");
	        	str_to_be_encr.append((char)136);
	        }
	        
	        if (e.getSource() == Dalet_button) {
	        	str_to_be_disp.insert(0, "ד");
	        	str_to_be_encr.append((char)137);
	        }
		    
	        if (e.getSource() == Gimel_button) {
	        	str_to_be_disp.insert(0, "ג");
	        	str_to_be_encr.append((char)138);
	        }
	        
	        if (e.getSource() == Kaf_button) {
	        	str_to_be_disp.insert(0, "כ");
	        	str_to_be_encr.append((char)139);
	        }
	        
	        if (e.getSource() == Ayin_button) {
	        	str_to_be_disp.insert(0, "ע");
	        	str_to_be_encr.append((char)140);
	        }
	        
	        if (e.getSource() == Yud_button) {
	        	str_to_be_disp.insert(0, "י");
	        	str_to_be_encr.append((char)141);
	        }
	        
	        if (e.getSource() == Ches_button) {
	        	str_to_be_disp.insert(0, "ח");
	        	str_to_be_encr.append((char)142);
	        }
	        
	        if (e.getSource() == Lamed_button) {
	        	str_to_be_disp.insert(0, "ל");
	        	str_to_be_encr.append((char)143);
	        }
	        
	        if (e.getSource() == Chaf_end_button) {
	        	str_to_be_disp.insert(0, "ך");
	        	str_to_be_encr.append((char)144);
	        }
	        
	        if (e.getSource() == Pay_end_button) {
	        	str_to_be_disp.insert(0, "ף");
	        	str_to_be_encr.append((char)145);
	        }
	        
	        if (e.getSource() == Zayin_button) {
	        	str_to_be_disp.insert(0, "ז");
	        	str_to_be_encr.append((char)146);
	        }
	        
	        if (e.getSource() == Samach_button) {
	        	str_to_be_disp.insert(0, "ס");
	        	str_to_be_encr.append((char)147);
	        }
	        
	        if (e.getSource() == Veis_button) {
	        	str_to_be_disp.insert(0, "ב");
	        	str_to_be_encr.append((char)148);
	        }
	        
	        if (e.getSource() == Hay_button) {
	        	str_to_be_disp.insert(0, "ה");
	        	str_to_be_encr.append((char)149);
	        }
	        
	        if (e.getSource() == Nun_button) {
	        	str_to_be_disp.insert(0, "נ");
	        	str_to_be_encr.append((char)150);
	        }
	        
	        if (e.getSource() == Mem_button) {
	        	str_to_be_disp.insert(0, "מ");
	        	str_to_be_encr.append((char)151);
	        }
	        
	        if (e.getSource() == Tsadeh_button) {
	        	str_to_be_disp.insert(0, "צ");
	        	str_to_be_encr.append((char)152);
	        }
	        
	        if (e.getSource() == Tav_button) {
	        	str_to_be_disp.insert(0, "ת");
	        	str_to_be_encr.append((char)153);
	        }
	        
	        if (e.getSource() == Tsadeh_end_button) {
	        	str_to_be_disp.insert(0, "ץ");
	        	str_to_be_encr.append((char)154);
	        }
		    
		    String nstr = "";
	        char tstrdch;
	        for (int i=0; i < str_to_be_disp.length(); i++)
	        {
	        	tstrdch = str_to_be_disp.charAt(i);
	        	nstr= tstrdch+nstr;
	        }
	        
	        disp_text.setText("מילה" + ": " + nstr);
	        /*
	        System.out.println();
	        for (int i = 0; i < str_to_be_encr.length(); i++) {
	            System.out.print((int)str_to_be_encr.charAt(i));
	            if (i < str_to_be_encr.length() - 1)
	            	System.out.print(", ");
	        }
	        */
	        if (e.getSource() == Add_button) {
	        	Worderize_main.enc_str = "";
	            Worderize_main.encrypt_string(Worderize_main.gen_trash() + str_to_be_encr.toString());
	            String enc_word = Worderize_main.enc_str;
	            Worderize_main.enc_str = "";
	            Worderize_main.set_salt_and_iv();
	            Worderize_main.encrypt_string(Worderize_main.gen_trash() + txpane.getText());
	            Worderize_main.set_salt_and_iv();
	            Worderize_main.add_word_to_db(Base64.getEncoder().encodeToString(enc_word.getBytes()), Base64.getEncoder().encodeToString(Worderize_main.enc_str.getBytes()));
	            Worderize_main.enc_str = "";
	        	this.dispose();
	        }
	        
	        if (e.getSource() == Cancel_button) {
	        	this.dispose();
	        }
	    }
}