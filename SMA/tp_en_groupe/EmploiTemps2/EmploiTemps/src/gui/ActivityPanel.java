package gui;

/*
 * @(#)MasterData.java	1.14 04/07/26
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import metier.DataSet;
import metier.StudentSet;
import metier.SubjectSet;



/**
 * Internal Frames Demo
 */
public class ActivityPanel extends TTGSModule {
	
	JDialog actDialog;
	JPanel activityBasePanel;
	JButton clearTBtn, clearSBtn, assignTchSub, assignStudSub;
	JTabbedPane tabbedpane;
	JList ACTList,TList, TSList, SList, SSList, SUBList;
	JTextArea ACTTextArea,SUBTextArea;

	SubjectSet selSubSet;
	JComboBox jcbATag, jcbSub;
	JTextField jtfAPW, jtfDura;
	String selSub,selActTag;
	
	Vector<String> TVList = new Vector<String>();
	Vector<String> TSVList = new Vector<String>();
	Vector<String> SVList = new Vector<String>();
	Vector<String> SSVList = new Vector<String>();
	Vector<String> ActDataList = new Vector<String>();
	Vector<String> SUBVList = new Vector<String>();

	public JPanel getActivityPanel() {
		return activityBasePanel;
	}

	public void UploadListData(int c) {		
		switch (c) {
		case DataSet.TEACHER:
			TVList.clear();
			for (int i = 0; i < getTTGSData().getTeacherLength(); i++)
				TVList.add(i, getTTGSData().getTeacher(i).getName());
			if(TVList.isEmpty()){
				TVList.add("------(Pas d'enseignant)------");
				TList.setEnabled(false);
				TSList.setEnabled(false);
			}else{
				TList.setEnabled(true);
				TSList.setEnabled(true);
			}
			TList.setListData(TVList);
			break;
		case DataSet.STUDENT:
			SVList.clear();
			for (int i = 0; i < getTTGSData().getStudentLength(); i++) 
				SVList.add(getTTGSData().getStudent(i).getName());
			if(SVList.isEmpty()){
				SVList.add("------(Pas d'étudiant)------");
				SList.setEnabled(false);
				SSList.setEnabled(false);
			}else{
				SList.setEnabled(true);
				SSList.setEnabled(true);
			}
			SList.setListData(SVList);
			break;
		case DataSet.SUBJECT:
			jcbSub.removeAllItems();
			jcbSub.updateUI();
			if (getTTGSData().getSubjectLength() == 0)
				jcbSub.addItem("Pas de cours");
			else
				jcbSub.addItem("Selectionner un cour");
			for (int i = 0; i < getTTGSData().getSubjectLength(); i++)
				jcbSub.addItem(getTTGSData().getSubject(i).getName());
			break;
		case DataSet.ACTIVITY:
			ActDataList.clear();
			for (int i = 0; i < getTTGSData().getActivityLength(); i++){
				String s="| ";
				for(int j=0;j<getTTGSData().getActivityRecord(i).length;j++)
				 s += String.valueOf(getTTGSData().getActivityRecord(i)[j])+" | " ;
				ActDataList.add(i,s);
			}
			ACTTextArea.setText("Détail activités:\n======================");
			ACTList.removeAll();
			ACTList.setListData(ActDataList);
			break;
		case DataSet.ASSIGNSUBJECT:
			getTTGSData().copySubjToAssignSubj();
			getTTGSData().updateAssignSubj();
			SUBList.removeAll();
			SUBVList.clear();
			for (int i = 0; i < getTTGSData().getAssigndSubjectLength(); i++){
				String s=getTTGSData().getSubjectsTHRecord(i);
				s+=getTTGSData().getSubjectsPRRecord(i);
				SUBVList.add(i,s);
			}
			SUBList.setListData(SUBVList);
			break;
		}
	}

	/**
	 * MasterData Constructor
	 */
	
	public ActivityPanel(TTGS ttgs) {
		super(ttgs, "", "");

		ActDataList = new Vector<String>();
		TVList = new Vector<String>();
		TSVList = new Vector<String>();
		SVList = new Vector<String>();
		SSVList = new Vector<String>();
		SUBVList = new Vector<String>();
		TList = new JList();
		SList = new JList();
		TSList = new JList();
		SSList = new JList();
		
		TSList.setName("'Enseignant sélectionné'");
		SSList.setName("'Classe sélectionné'");
		jcbSub = new JComboBox();
		jcbATag = new JComboBox();
		jcbATag.setModel(new DefaultComboBoxModel(new String[] { "selectionner un  Tag", "Theorie", "Pratique"}));
		selSub="";
		selActTag="";
		jtfAPW=new JTextField();
		jtfDura=new JTextField();
		jtfAPW.setColumns(10);
		jtfDura.setColumns(10);
		jtfAPW.setText("Activité/Semaine");
		jtfDura.setText("Durée");
		jtfAPW.setEditable(false);
		jtfDura.setEditable(false);

		clearTBtn = new JButton("Effacer");
		clearSBtn = new JButton("Effacer");
		
		TList.setDragEnabled(true);
		TList.setDropTarget(getDND(TSVList, TList, TSList));
		TSList.setDropTarget(getDND(TSVList, TList, TSList));

		SList.setDragEnabled(true);
		SList.setDropTarget(getDND(SSVList, SList, SSList));
		SSList.setDropTarget(getDND(SSVList, SList, SSList));

		ACTList = new JList();
		ACTTextArea = new JTextArea();
		ACTTextArea.setEditable(false);
		ACTTextArea.setText("Details activités:\n======================");
		ACTList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(ACTList.getSelectedIndex()>-1)
					ACTTextArea.setText("Details activités:\n======================\n"
					+ ActDataList.get(ACTList.getSelectedIndex()).replace("|", "\n"));
			}
		});

		SUBList = new JList();
		SUBTextArea = new JTextArea();
		SUBTextArea.setEditable(false);
		SUBTextArea.setText("Details Cours\n======================");
		SUBList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(SUBList.getSelectedIndex()>-1){
					jcbSub.setSelectedIndex(SUBList.getSelectedIndex()+1);
					SUBTextArea.setText("Details Cours:\n======================\n"
					+ SUBVList.get(SUBList.getSelectedIndex()).replace("[", "\n").replace("]", "."));
				}
			}
		});
		

		clearTBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TSList.removeAll();
				TSList.updateUI();
				TSVList.clear();
			}
		});

		clearSBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SSList.removeAll();
				SSList.updateUI();
				SSVList.clear();
			}
		});

		jcbSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jcbSub.getItemCount() > 0){
					if (!jcbSub.getSelectedItem().toString().contains("cour")){
						SUBList.setSelectedIndex(jcbSub.getSelectedIndex()-1);
						selSub=jcbSub.getSelectedItem().toString();
						selSubSet=getTTGSData().getSubject(getTTGSData().searchSubject(selSub));
					}else {
						jcbATag.setSelectedIndex(0);
						selSub="";
						selActTag="";
					}
					UpdateJCB();
				}
			}
		});
		
		jcbATag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jcbATag.getItemCount() > 0){
					if (!jcbATag.getSelectedItem().toString().contains("Tag"))
						selActTag=jcbATag.getSelectedItem().toString();
					else {
						jcbSub.setSelectedIndex(0);
						selSub="";
						selActTag="";
					}
					UpdateJCB();
				}
			}
		});
		activityBasePanel = getActContentBasePanel();
	}
	
	protected void UpdateJCB() {

		if(!selActTag.equalsIgnoreCase("") && !selSub.equalsIgnoreCase("")){
		String name,tppw,pppw;
		name=selSubSet.getName();
		tppw=String.valueOf(selSubSet.getTPPW()/Integer.parseInt(getString("MasterData.Dur_Theory")));
		pppw=String.valueOf(selSubSet.getPPPW()/Integer.parseInt(getString("MasterData.Dur_Practical")));
			if(selActTag.equalsIgnoreCase("Theorie")){
				jtfAPW.setText(tppw);
				jtfDura.setText(getString("MasterData.Dur_Theory"));			
			}else if(selActTag.equalsIgnoreCase("Pratique")){
				jtfAPW.setText(pppw);
				jtfDura.setText(getString("MasterData.Dur_Practical"));						
			}else{
				jtfAPW.setText("Activité/Semaine");
				jtfDura.setText("Duration");
			}
		}else{
			jtfAPW.setText("Activité/Semaine");
			jtfDura.setText("Durée");
		}
	}

	protected JPanel getSubAssignPanel(String s,int i) {
		assignTchSub = new JButton("Assigner");
		assignStudSub = new JButton("Assigner");
		
		JPanel activityPanel = new JPanel();

		JPanel act1Panel , act2Panel ;
		act1Panel = getActInnerPanel("Paramètres Cours: ",jcbATag,jcbSub,jtfDura,jtfAPW);
		if(i==0) act2Panel = getActInnerPanel("Liste enseignant : ",TList,TSList,clearTBtn,null);
		else if(i==1) act2Panel = getActInnerPanel("Liste Classe: ",SList,SSList,clearSBtn,null);		
		else act2Panel = new JPanel();			
		
		activityPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 2, 10, 2);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridx =1;
		gbc.gridy =1;
		activityPanel.add(act1Panel,gbc);
		gbc.gridy =10;
		activityPanel.add(act2Panel,gbc);
		
		JPanel SubPanel = new JPanel();
		SubPanel.setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder(""));
		jp.add(new JLabel(s));
		if(i==0)
		jp.add(assignTchSub);
		else if(i==1)
		jp.add(assignStudSub);
		
		assignTchSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selSubSet!=null){
					int i= getTTGSData().searchAssigndSubject(selSubSet.getName());
					if(TSList.getModel().getSize()>0){
						String s= TSList.getModel().getElementAt(0).toString();
						assignTchSub_Func(i,s);
					}
					else
					MSGBOX("Vide", "Doit sélectionner au moins un enseignant",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		assignStudSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selSubSet!=null){
					int i= getTTGSData().searchAssigndSubject(selSubSet.getName());
					if(SSList.getModel().getSize()>0){
						String s= SSList.getModel().getElementAt(0).toString();
						assignStudSub_Func(i,s);
					}
					else
					MSGBOX("Vide", "Vide, doit sélectionner au moins un élève",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JPanel subListPanel = new JPanel();
		subListPanel.setBorder(new TitledBorder(" Liste de matières : "));
		subListPanel.setLayout(new GridLayout(1, 1, 10, 10));
		subListPanel.add(new JScrollPane(SUBList));

		JPanel sidePanel = new JPanel();
		sidePanel.setBorder(new TitledBorder(" Description des matières : "));
		sidePanel.setLayout(new GridLayout(1, 1, 10, 10));
		sidePanel.add(new JScrollPane(SUBTextArea));
		
		SubPanel.add(activityPanel,BorderLayout.LINE_START);
		SubPanel.add(subListPanel,BorderLayout.CENTER);
		SubPanel.add(sidePanel,BorderLayout.LINE_END);
		SubPanel.add(jp,BorderLayout.SOUTH);
		
		return SubPanel;
	}

	protected void assignTchSub_Func(int i, String s) {
		if(selActTag.equalsIgnoreCase("Theorie")){
			if(TSList.getModel().getSize()>1){
				MSGBOX("Sélection invalide", "Vous devez selectionner seulement un enseignant",JOptionPane.INFORMATION_MESSAGE);
				TSList.removeAll();
				TSList.updateUI();
				TSVList.clear();
			}else getTTGSData().getAssigndSubject(i).setTchTH(s);
		}
		else if(selActTag.equalsIgnoreCase("Pratique")){
			int slimit=getTTGSData().getAssigndSubject(i).getStudPR().size();
			if(TSList.getModel().getSize() > slimit){
				MSGBOX("Selection invalide", "vous devez selectionner moins de " +slimit +" Eseignant",JOptionPane.INFORMATION_MESSAGE);
				TSList.removeAll();
				TSList.updateUI();
				TSVList.clear();
			}else{
				getTTGSData().getAssigndSubject(i).clearTchPR();
				for(int j = 0;j<TSList.getModel().getSize();j++){
					String ss=TSList.getModel().getElementAt(j).toString();
					getTTGSData().getAssigndSubject(i).getTchPR().add(j,ss);
				}
			} 
		}else{
			MSGBOX("Vide","Selectionner d'abord le tag",JOptionPane.INFORMATION_MESSAGE);
		}
		UploadListData(DataSet.ASSIGNSUBJECT);
	}

	protected void assignStudSub_Func(int i,String s) {
		if(selActTag.equalsIgnoreCase("Theorie")){
            if(SSList.getModel().getSize()>1){
				MSGBOX("Selection invalide", "Veuillez selectionner seulement un étudiant",JOptionPane.INFORMATION_MESSAGE);
				SSList.removeAll();
				SSList.updateUI();
				SSVList.clear();
			}else getTTGSData().getAssigndSubject(i).setStudTH(s);
		}
		else if(selActTag.equalsIgnoreCase("Pratique")){
			if(SSList.getModel().getSize() > 1){
				MSGBOX("Selection invalide", "Veuillez selectionner seulement un " +
				"\n Les classes liées sont automatiquement ajoutées !",JOptionPane.INFORMATION_MESSAGE);
				SSList.removeAll();
				SSList.updateUI();
				SSVList.clear();
			}else {
				getTTGSData().getAssigndSubject(i).clearStudPR();
				StudentSet stud =getTTGSData().getStudent(getTTGSData().searchStudent(s));
				
				if(stud.getGroupList().size()>0)
				for(int j = 0;j<stud.getGroupList().size();j++){
					s=stud.getGroupName(j);
					getTTGSData().getAssigndSubject(i).getStudPR().add(j,s);
				}
				else MSGBOX("Erreur création de groupe", "Les groupes n'ont pas été crées!",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			MSGBOX("Selection invalide","Veuillez d'abord selectionner le tag",JOptionPane.INFORMATION_MESSAGE);
		}
		UploadListData(DataSet.ASSIGNSUBJECT);
	}

	protected JPanel getActContentBasePanel() {
		JPanel actListPanel = new JPanel();
		actListPanel.setBorder(new TitledBorder(" Liste des activités : "));
		actListPanel.setLayout(new GridLayout(1, 1, 10, 10));
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBorder(new TitledBorder(" Description de l'activité : "));
		sidePanel.setLayout(new GridLayout(1, 1, 10, 10));
		
		actListPanel.add(new JScrollPane(ACTList));
		sidePanel.add(new JScrollPane(ACTTextArea));

		JPanel btnPanel = new JPanel();
		btnPanel.setBorder(new LineBorder(Color.WHITE, 2));
		btnPanel.setLayout(new GridLayout(1, 3, 10, 10));

		JButton relTchSub = new JButton("Cours - Enseignant");
		relTchSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actDialog = new JDialog(ttgs.getFrame(), "Cours - Affectation enseignant", true);
				actDialog.setSize(900, 600);
				actDialog.setResizable(false);
				actDialog.setLocation(100, 100);
				actDialog.setContentPane(getSubAssignPanel(getString("Activity.relTchSub"),0));
				actDialog.show();
			}
		});
		
		JButton relStudSub = new JButton("Cours - Classe");
		relStudSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actDialog = new JDialog(ttgs.getFrame(), "Cours - Classe affectation", true);
				actDialog.setSize(900, 600);
				actDialog.setResizable(false);
				actDialog.setLocation(100, 100);
				actDialog.setContentPane(getSubAssignPanel(getString("Activity.relStudSub"),1));
				actDialog.show();
			}
		});

		JButton genAct = new JButton("Générer activités");
		genAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getTTGSData().isUptodate()){
					TTGSGenerator tg=getTTGSGenerator();
					tg.GenerateActivities();
					if(tg.isActivitiesGenerated())
						JOptionPane.showMessageDialog(null, "Activités générées ");
					else
						JOptionPane.showMessageDialog(null, "Erreur: pas d'activité générée");
				}
				else
				JOptionPane.showMessageDialog(null, "Erreur: pas d'activité générée");
				UploadListData(DataSet.ACTIVITY);
			}
		});
		
		btnPanel.add(relStudSub);
		btnPanel.add(relTchSub);
		btnPanel.add(genAct);

		JPanel ActContentBasePanel = new JPanel();
		ActContentBasePanel.setLayout(new BorderLayout());
		ActContentBasePanel.add(new JLabel(getString("Activity.description")),BorderLayout.NORTH);
		ActContentBasePanel.add(actListPanel, BorderLayout.CENTER);
		ActContentBasePanel.add(sidePanel, BorderLayout.LINE_END);
		ActContentBasePanel.add(btnPanel, BorderLayout.SOUTH);

		return ActContentBasePanel;
	}

	protected JPanel getActInnerPanel(String title,Component comp1,Component comp2,Component comp3,Component comp4) {

		JPanel activityInnerPanel = new JPanel();
		JScrollPane tmp;
		
		activityInnerPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx =1;
		gbc.gridy =20;
		if(title.contains("List")){
			tmp = new JScrollPane(comp1);
			tmp.setPreferredSize(new Dimension(200, 225));
			activityInnerPanel.add(tmp, gbc);
			
			gbc.gridx = 20;
			tmp = new JScrollPane(comp2);
			tmp.setPreferredSize(new Dimension(200, 225));
			activityInnerPanel.add(tmp, gbc);
		}else{
			gbc.gridx =1;
			gbc.gridy =20;
			activityInnerPanel.add(comp1, gbc);

			gbc.gridx = 20;
			activityInnerPanel.add(comp2, gbc);			
		}
		//comp1,comp2,comp3,comp4
		//jcbATag,jcbSub,jtfDura,jtfAPW		
		if(comp4!=null){
			gbc.gridx = 1;
			gbc.gridy = 30;
			activityInnerPanel.add(new JLabel("Durée"), gbc);
			gbc.gridx = 20;
			activityInnerPanel.add(comp3, gbc);			
			gbc.gridx = 1;
			gbc.gridy = 40;
			activityInnerPanel.add(new JLabel("Activité/Weekend"), gbc);
			gbc.gridx = 20;
			activityInnerPanel.add(comp4, gbc);
		}else {
			gbc.gridx = 20;
			gbc.gridy = 30;
			activityInnerPanel.add(comp3, gbc);			
		}

		JLabel tmplbl;
		if(title.contains("Teacher"))
			tmplbl=new JLabel(getString("Activity.tch_description"));
		else if(title.contains("Student"))
			tmplbl=new JLabel(getString("Activity.stud_description"));
		else
		    tmplbl=new JLabel(getString("Activity.subjtag_description"));
		
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridBagLayout());		
		tempPanel.setBorder(new TitledBorder(title));
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(1, 0, 1, 0);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx =1;
		gbc.gridy =1;
		tempPanel.add(tmplbl,gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx =1;
		gbc.gridy =20;
		tempPanel.add(activityInnerPanel,gbc);
		
		return tempPanel;
	}

	protected DropTarget getDND(final Vector<String> selVList, final JList oList,
			final JList selList) {
		DropTarget dnd = new DropTarget(selList, new DropTargetListener() {
			public void dragEnter(DropTargetDragEvent arg0) {
			}

			public void dragExit(DropTargetEvent arg0) {
			}

			public void dragOver(DropTargetDragEvent arg0) {
			}

			public void drop(DropTargetDropEvent arg0) {
				try {
					if (!isDuplicate(selVList, oList.getSelectedValue().toString(), selList)) {
						selVList.add(oList.getSelectedValue().toString());
						selList.setListData(selVList);
					}
				} catch (Exception e) {
					System.out.println(arg0.getSource().toString() + ":"+ e.getMessage());
				}
				selList.clearSelection();
				oList.clearSelection();
			}

			private boolean isDuplicate(Vector<String> vList, String key,JList selList) {
				if (vList.isEmpty())
					return false;
				else {
					for (int i = 0; i < vList.size(); i++) {
						if (vList.get(i).equals(key))
							return true;
					}
				}
				return false;
			}
			public void dropActionChanged(DropTargetDragEvent arg0) {
			}
		});
		return dnd;
	}
}
