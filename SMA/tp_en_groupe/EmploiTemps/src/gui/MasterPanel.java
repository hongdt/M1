package gui;

/*
 * @(#)MasterData.java
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.*;

import metier.DataSet;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class MasterPanel extends TTGSModule {
	ArrayList<JTextField> jtfDay = new ArrayList<JTextField>();
	ArrayList<JTextField> jtfHour = new ArrayList<JTextField>();

	JComboBox jcbStud;
	JTextField name = new JTextField();
	JTextField gname = new JTextField();
	JTextField type = new JTextField();
	JTextField pppw = new JTextField();
	JTextField tppw = new JTextField();
	JTextField strength = new JTextField();
	JTextField capacity = new JTextField();
	JSpinner daySpin = new JSpinner();
	JSpinner hourSpin = new JSpinner();

	JPanel gPanel, masterPanel, deptPanel, buttonPanel;
	JList commonList;
	JTextArea commonListDisplay;

	JButton showBtn, cancelBtn, createBtn, addBtn, editBtn, removeBtn;
	JTabbedPane tabbedpane;
	JTable tableView;
	JScrollPane scrollpane, tableAggregate;

	final int INITIAL_ROWHEIGHT = 20;
	String[] tchnames = { "Nom Enseignant", "Type Enseignant" };
	String[] studnames = { "Nom Classe", "Nombre Etudiant" };
	String[] roomnames = { "Nom Salle", "Type de salle", "Capacité salle" };
	String[] subjnames = { "Nom Matière", "Nombre de Theorie/Semaine","Nombre de Pratique/Semaine" };

	Vector<String> tmpList = new Vector<String>();
	Vector<String> dataList = new Vector<String>();
	Vector<Object[]> dataTable = new Vector<Object[]>();

	/**
	 * MasterData Constructor
	 */
	public MasterPanel(TTGS ttgs) {
		super(ttgs, "", "");
		JButton tchB, subjB, studB, roomB, timeB;

		InitJTF();
		InitTimeJTF();
		tmpList = new Vector<String>();
		dataList = new Vector<String>();
		dataTable = new Vector<Object[]>();

		commonList = new JList();
		commonListDisplay = new JTextArea();
		commonListDisplay.setColumns(20);
		commonListDisplay.setEditable(false);
		commonListDisplay.setSize(100, 200);
		
		commonList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(commonList.getSelectedIndex()>-1)
				commonListDisplay.setText(dataList.get(commonList.getSelectedIndex()));
			}
		});
		

		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// Data Entry
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		masterPanel = new JPanel();
		deptPanel = new JPanel();
		buttonPanel = new JPanel();

		masterPanel.setLayout(new BorderLayout());
		deptPanel.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(1, 4));
		masterPanel.add(buttonPanel, BorderLayout.NORTH);
		masterPanel.add(deptPanel, BorderLayout.CENTER);

		tchB = new JButton(getString("MasterData.tch"));
		subjB = new JButton(getString("MasterData.subj"));
		studB = new JButton(getString("MasterData.stud"));
		roomB = new JButton(getString("MasterData.room"));
		timeB = new JButton(getString("MasterData.time"));

		buttonPanel.add(tchB);
		buttonPanel.add(subjB);
		buttonPanel.add(studB);
		buttonPanel.add(roomB);
		buttonPanel.add(timeB);

		tchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitJTF();
				deptPanel.removeAll();
				deptPanel.add(getTeacharContent(getString("MasterData.tch")),BorderLayout.CENTER);
				deptPanel.updateUI();
				createTable(DataSet.TEACHER, tchnames);
			}
		});

		subjB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitJTF();
				deptPanel.removeAll();
				deptPanel.add(getSubjectContent(getString("MasterData.subj")),BorderLayout.CENTER);
				deptPanel.updateUI();
				createTable(DataSet.SUBJECT, subjnames);
			}
		});

		studB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitJTF();
				deptPanel.removeAll();
				deptPanel.add(getStudentContent(getString("MasterData.stud")),BorderLayout.CENTER);
				deptPanel.updateUI();
				createTable(DataSet.STUDENT, studnames);
			}
		});

		roomB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitJTF();
				deptPanel.removeAll();
				deptPanel.add(getRoomContent(getString("MasterData.room")),BorderLayout.CENTER);
				deptPanel.updateUI();
				createTable(DataSet.ROOM, roomnames);
			}
		});

		timeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitTimeJTF();
				deptPanel.removeAll();
				deptPanel.add(getTimeContent(getString("MasterData.time")),BorderLayout.CENTER);
				deptPanel.updateUI();
				ValidateTime();
			}
		});
	}

	public JPanel getMasterPanel() {
		return masterPanel;
	}

	public JPanel getTimeContent(String title) {
		JPanel TimeContentPanel = new JPanel();

		JPanel btnPanel;
		JButton addBtn = new JButton("Ajouter");
		JPanel dayPanel = new JPanel();
		JPanel hourPanel = new JPanel();
		JPanel spinPanel = new JPanel();

		GridBagConstraints c = new GridBagConstraints();

		dayPanel.setBorder(new TitledBorder(" Jours : "));
		hourPanel.setBorder(new TitledBorder(" Heures : "));
		spinPanel.setBorder(new LineBorder(Color.WHITE, 2));
		TimeContentPanel.setLayout(new GridBagLayout());
		dayPanel.setLayout(new GridLayout(3, 2, 10, 10));
		hourPanel.setLayout(new GridLayout(4, 3, 10, 10));
		spinPanel.setLayout(new GridBagLayout());

		InitTimeJTF();
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(20, 10, 20, 10);
		for (int i = 0; i < DataSet.MAXDAY; i++) {
			btnPanel = new JPanel();
			btnPanel.setLayout(new GridBagLayout());
			btnPanel.add(new JLabel("Jour " + (i + 1) + ": "), c);
			btnPanel.add(jtfDay.get(i), c);
			dayPanel.add(btnPanel);
		}
		c.insets = new Insets(2, 1, 2, 1);
		for (int i = 0; i < DataSet.MAXHOUR; i++) {
			btnPanel = new JPanel();
			btnPanel.setLayout(new GridBagLayout());
			btnPanel.add(new JLabel("Heure " + (i + 1) + ": "), c);
			btnPanel.add(jtfHour.get(i), c);
			hourPanel.add(btnPanel);
		}

		// new SpinnerNumberModel(value, min, max, step);
		daySpin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1),new Integer(DataSet.MAXDAY), new Integer(1)));
		hourSpin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(DataSet.MAXHOUR), new Integer(1)));

		daySpin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				EnableJTF(jtfDay, Integer.parseInt(daySpin.getValue().toString()));
			}
		});

		hourSpin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				EnableJTF(jtfHour, Integer.parseInt(hourSpin.getValue().toString()));
			}
		});

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpadateTime();
			}
		});

		c.gridx = 1;
		c.gridy = 1;
		spinPanel.add(new JLabel("Nombre de Jours/Semaine : "), c);
		c.gridy = 10;
		spinPanel.add(daySpin, c);
		c.gridy = 20;
		spinPanel.add(new JLabel("Nombre d'Heure/Semaine : "), c);
		c.gridy = 30;
		spinPanel.add(hourSpin, c);
		c.gridy = 40;
		spinPanel.add(addBtn, c);

		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		TimeContentPanel.add(dayPanel, c);
		c.anchor = GridBagConstraints.LINE_END;
		TimeContentPanel.add(spinPanel, c);
		c.gridx = 1;
		c.gridy = 10;
		c.anchor = GridBagConstraints.WEST;
		TimeContentPanel.add(hourPanel, c);

		return TimeContentPanel;
	}

	public void ValidateTime() {
		if (!getTTGSData().getTimeSet().getDay().isEmpty()) {
			for (int i = 0; i < getTTGSData().getTimeSet().getDay().size(); i++) {
				jtfDay.get(i).setEnabled(true);
				jtfDay.get(i).setBackground(Color.WHITE);
				jtfDay.get(i).setText(getTTGSData().getTimeSet().getDay().get(i));
			}
			daySpin.setValue(getTTGSData().getTimeSet().getDay().size());
		}
		if (!getTTGSData().getTimeSet().getHour().isEmpty()) {
			for (int i = 0; i < getTTGSData().getTimeSet().getHour().size(); i++) {
				jtfHour.get(i).setEnabled(true);
				jtfHour.get(i).setBackground(Color.WHITE);
				jtfHour.get(i).setText(getTTGSData().getTimeSet().getHour().get(i));
			}
			hourSpin.setValue(getTTGSData().getTimeSet().getHour().size());
		}
	}

	public void UpadateTime() {
		getTTGSData().getTimeSet().getDay().removeAllElements();
		getTTGSData().getTimeSet().getHour().removeAllElements();
		for (int i = 0; i < jtfDay.size(); i++)
			if (jtfDay.get(i).isEnabled())
				getTTGSData().getTimeSet().getDay().addElement(jtfDay.get(i).getText());
		for (int i = 0; i < jtfHour.size(); i++)
			if (jtfHour.get(i).isEnabled())
				getTTGSData().getTimeSet().getHour().addElement(jtfHour.get(i).getText());
	}

	private void InitTimeJTF() {
		for (int i = 0; i < DataSet.MAXDAY; i++) {
			jtfDay.add(new JTextField());
			jtfDay.get(i).setColumns(10);
			jtfDay.get(i).setBackground(Color.LIGHT_GRAY);
			jtfDay.get(i).setEnabled(false);
		}

		for (int i = 0; i < DataSet.MAXHOUR; i++) {
			jtfHour.add(new JTextField());
			jtfHour.get(i).setColumns(10);
			jtfHour.get(i).setBackground(Color.LIGHT_GRAY);
			jtfHour.get(i).setEnabled(false);
		}
	}

	public void EnableJTF(ArrayList<JTextField> jtf, int value) {
		for (int i = 0; i < jtf.size(); i++) {
			if (i <= value - 1) {
				jtf.get(i).setEnabled(true);
				jtf.get(i).setBackground(Color.WHITE);
			} else {
				jtf.get(i).setText("");
				jtf.get(i).setEnabled(false);
				jtf.get(i).setBackground(Color.LIGHT_GRAY);
			}
		}
	}

	private void InitJTF() {
		name = new JTextField();
		gname = new JTextField();
		type = new JTextField();
		pppw = new JTextField();
		tppw = new JTextField();
		strength = new JTextField();
		capacity = new JTextField();

		name.setColumns(20);
		gname.setColumns(20);
		type.setColumns(20);
		pppw.setColumns(20);
		tppw.setColumns(20);
		strength.setColumns(20);
		capacity.setColumns(20);

		jcbStud = new JComboBox();
		if (getTTGSData().getStudentLength() == 0)
			jcbStud.addItem("Pas d'étudiant");
		else
			jcbStud.addItem("choisir étudiant");

		jcbStud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jcbStud.getItemCount() > 0)
					if (!jcbStud.getSelectedItem().toString().contains("étudiant"))
						name.setText(jcbStud.getSelectedItem().toString());
			}
		});

	}

	public void RefreshTable(ShowHidePanel P0,int c,String[] s){
		P0.getPanelSet(1).removeAll();
		P0.SHOWP();
		createTable(c, s);
		P0.getPanelSet(1).add(tableAggregate);
		P0.getPanelSet(1).updateUI();				
	}
	
	public JPanel getTeacharContent(String title) {
		final ShowHidePanel P0 = new ShowHidePanel();
		P0.getPanelSet(0).setLayout(new GridBagLayout());
		P0.getPanelSet(1).setLayout(new BorderLayout());
		P0.getPanelSet(2).setLayout(new BorderLayout(10, 10));
		P0.getPanelSet(2).setBorder(new TitledBorder(title + " Liste : "));
		cancelBtn = new JButton("Annuler");

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2);
		gbc.anchor = GridBagConstraints.LINE_END;
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// Teacher
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		P0.getPanelSet(3).setLayout(new GridBagLayout());
		addBtn = new JButton("Ajouter Enseignant");
		editBtn = new JButton("Modifier Enseignant");
		removeBtn = new JButton("Enlever Enseignant");
		showBtn = new JButton("Afficher");
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		P0.getPanelSet(3).add(editBtn, gbc);
		gbc.gridx = 10;
		P0.getPanelSet(3).add(removeBtn, gbc);
		gbc.gridx = 20;
		P0.getPanelSet(3).add(cancelBtn, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		P0.getPanelSet(0).add(new JLabel("Nom Professeur : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(name, gbc);
		gbc.gridy = 40;

		gbc.gridx = 1;
		gbc.gridy = 10;
		P0.getPanelSet(0).add(new JLabel("Type Professeur : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(type, gbc);
		gbc.gridy = 40;
		P0.getPanelSet(0).add(addBtn, gbc);
		gbc.gridx = 20;
		P0.getPanelSet(0).add(showBtn, gbc);

		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshTable(P0, DataSet.TEACHER,tchnames);
			}
		});
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(P0.validate(name, 0) && P0.validate(type, 0))) {
					JOptionPane.showMessageDialog(null, "Remplir les champs vides!","Vidé", JOptionPane.INFORMATION_MESSAGE);
				} else
					getTTGSData().addTeacher(name.getText(), type.getText());
				RefreshTable(P0, DataSet.TEACHER,tchnames);
			}
		});
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editBtn.getText().equalsIgnoreCase("Modifier Professeur")) {
					if (tableView.getSelectedRow() != -1) {
						EditRow(tableView.getSelectedRow());
						editBtn.setText("Enregistrer");
						addBtn.setEnabled(false);
						JOptionPane.showMessageDialog(null,
								"Vous avez sélectionné la ligne[" + tableView.getSelectedRow() + "] de " + tableView.getName(),"Modifier", JOptionPane.INFORMATION_MESSAGE);
					} else
						JOptionPane.showMessageDialog(null,"Vous devez d'abord selectionner ", "Modifier",JOptionPane.INFORMATION_MESSAGE);
				} else if (editBtn.getText().equalsIgnoreCase("Enregistrer")) {
					if (tableView.getSelectedRow() != -1) {
						if (SaveRow(tableView.getSelectedRow())) {
							RefreshTable(P0, DataSet.TEACHER,tchnames);
							editBtn.setText("Modifier Enseignant");
							addBtn.setEnabled(true);
							JOptionPane.showMessageDialog(null,"Vous avez enregistré les lignes avec succès[" + tableView.getSelectedRow() + "] de " + tableView.getName(),"Enregistrer", JOptionPane.INFORMATION_MESSAGE);
						}
					} else
						JOptionPane.showMessageDialog(null,"Premièrement, vous devez selectionner ", "Enregistrer",JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableView.getSelectedRow() != -1) {
					String tmp = tableView.getValueAt(tableView.getSelectedRow(), 0).toString();
					if (JOptionPane.showConfirmDialog(null,"Voulez vous effacer une ligne" + tmp) == JOptionPane.YES_OPTION) {
						getTTGSData().removeTeacher(tableView.getSelectedRow());
						RefreshTable(P0, DataSet.TEACHER,tchnames);
						JOptionPane.showMessageDialog(null,"Vous avez effacé la ligne avec succès " + tmp + " de " + tableView.getName(), "Effacer",JOptionPane.INFORMATION_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(null,"Premièrementn vous devez selectionner ", "Effacer",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editBtn.setText("Modifier Enseignant");
				addBtn.setEnabled(true);
			}
		});

		commonListDisplay.setText("");
		P0.getPanelSet(2).add(new JScrollPane(commonList), BorderLayout.CENTER);
		P0.getPanelSet(2).add(new JScrollPane(commonListDisplay),BorderLayout.LINE_END);

		return P0.addPanelSet(title);

	}

	public JPanel getSubjectContent(String title) {
		final ShowHidePanel P0 = new ShowHidePanel();
		P0.getPanelSet(0).setLayout(new GridBagLayout());
		P0.getPanelSet(1).setLayout(new BorderLayout());
		P0.getPanelSet(2).setLayout(new BorderLayout(10, 10));
		P0.getPanelSet(2).setBorder(new TitledBorder(title + " Liste : "));
		cancelBtn = new JButton("Annuler");

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2);
		gbc.anchor = GridBagConstraints.LINE_END;

		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// Subject
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		P0.getPanelSet(3).setLayout(new GridBagLayout());
		addBtn = new JButton("Ajouter Cours");
		editBtn = new JButton("Modifier Cours");
		removeBtn = new JButton("Enlever Cours");
		showBtn = new JButton("Afficher");
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		P0.getPanelSet(3).add(editBtn, gbc);
		gbc.gridx = 10;
		P0.getPanelSet(3).add(removeBtn, gbc);
		gbc.gridx = 20;
		P0.getPanelSet(3).add(cancelBtn, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		P0.getPanelSet(0).add(new JLabel("Nom du cour: "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(name, gbc);

		gbc.gridx = 1;
		gbc.gridy = 10;
		P0.getPanelSet(0).add(new JLabel("Nombre de cours théorique/Semaine : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(tppw, gbc);

		gbc.gridx = 1;
		gbc.gridy = 20;
		P0.getPanelSet(0).add(new JLabel("Nombre de cours pratiques/Semaine : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(pppw, gbc);
		gbc.gridy = 40;
		P0.getPanelSet(0).add(addBtn, gbc);
		gbc.gridx = 20;
		P0.getPanelSet(0).add(showBtn, gbc);
		
		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshTable(P0,DataSet.SUBJECT, subjnames);
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(P0.validate(name, 0) && P0.validate(tppw, 0) && P0.validate(pppw, 0))) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs","Vide", JOptionPane.INFORMATION_MESSAGE);
				} else if (!(P0.validate(tppw, 1) && P0.validate(pppw, 1))) {
					JOptionPane.showMessageDialog(null, "le champ est un entier","Nombre", JOptionPane.ERROR_MESSAGE);
				} else {
					getTTGSData().addSubject(name.getText(),Integer.parseInt(tppw.getText()),Integer.parseInt(pppw.getText()));
				}
				RefreshTable(P0,DataSet.SUBJECT, subjnames);
			}
		});
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editBtn.getText().equalsIgnoreCase("Modifier Cour")) {
					if (tableView.getSelectedRow() != -1) {
						EditRow(tableView.getSelectedRow());
						editBtn.setText("Enregister");
						addBtn.setEnabled(false);
						JOptionPane.showMessageDialog(null,"Vous avez selectionné la ligne[" + tableView.getSelectedRow() + "] de " + tableView.getName(),"Modifier", JOptionPane.INFORMATION_MESSAGE);
					} else
						JOptionPane.showMessageDialog(null,"Premièrement, vous devez selectionner ", "Modifier",JOptionPane.INFORMATION_MESSAGE);
				} else if (editBtn.getText().equalsIgnoreCase("Enregistrer")) {
					if (tableView.getSelectedRow() != -1) {
						if (SaveRow(tableView.getSelectedRow())) {
							RefreshTable(P0,DataSet.SUBJECT, subjnames);
							editBtn.setText("Modifier Cour");
							addBtn.setEnabled(true);
							JOptionPane.showMessageDialog(null,"Les lignees ont été correctement enregistrée[" + tableView.getSelectedRow() + "] de " + tableView.getName(),"Enregistrer", JOptionPane.INFORMATION_MESSAGE);
						}
					} else
						JOptionPane.showMessageDialog(null,"Premièrement vous devez faire une selection ", "Save",JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableView.getSelectedRow() != -1) {
					String tmp = tableView.getValueAt(tableView.getSelectedRow(), 0).toString();
					if (JOptionPane.showConfirmDialog(null,"Voulez vous supprimer une ligne? " + tmp) == JOptionPane.YES_OPTION) {
						getTTGSData().removeSubject(tableView.getSelectedRow());
						RefreshTable(P0,DataSet.SUBJECT, subjnames);
						JOptionPane.showMessageDialog(null,"Ligne enlevée avec succès " + tmp + " de " + tableView.getName(), "Enlevé",JOptionPane.INFORMATION_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(null,"Premièrement, vous devez selectionner ", "Enlever",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editBtn.setText("Modifier Cour");
				addBtn.setEnabled(true);
			}
		});

		commonListDisplay.setText("");
		P0.getPanelSet(2).add(new JScrollPane(commonList), BorderLayout.CENTER);
		P0.getPanelSet(2).add(new JScrollPane(commonListDisplay),BorderLayout.LINE_END);

		return P0.addPanelSet(title);

	}

	public JPanel getStudentContent(String title) {
		gPanel = new JPanel();
		gPanel.setLayout(new GridBagLayout());
		gPanel.setVisible(false);
		gname.setVisible(false);
		jcbStud.setVisible(false);

		final ShowHidePanel P0 = new ShowHidePanel();
		P0.getPanelSet(0).setLayout(new GridBagLayout());
		P0.getPanelSet(1).setLayout(new BorderLayout());
		P0.getPanelSet(2).setLayout(new BorderLayout(10, 10));
		P0.getPanelSet(2).setBorder(new TitledBorder(title + " List : "));
		cancelBtn = new JButton("Annuler");
		createBtn = new JButton("Créer Groupe");

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2);
		gbc.anchor = GridBagConstraints.LINE_END;

		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// Student
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		P0.getPanelSet(3).setLayout(new GridBagLayout());
		addBtn = new JButton("Ajouter Classe");
		editBtn = new JButton("Modifier Classe");
		removeBtn = new JButton("Enlever Classe");
		showBtn = new JButton("Afficher");

		gbc.gridx = 1;
		gbc.gridy = 1;
		P0.getPanelSet(3).add(editBtn, gbc);
		gbc.gridx = 10;
		P0.getPanelSet(3).add(removeBtn, gbc);
		gbc.gridx = 20;
		P0.getPanelSet(3).add(cancelBtn, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gPanel.add(new JLabel("Nom du groupe d'étudiant(classe) : "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		P0.getPanelSet(0).add(new JLabel("Nom de la Classe : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(name, gbc);
		P0.getPanelSet(0).add(jcbStud, gbc);

		gbc.gridx = 1;
		gbc.gridy = 10;
		P0.getPanelSet(0).add(gPanel, gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(gname, gbc);

		gbc.gridx = 1;
		gbc.gridy = 20;
		P0.getPanelSet(0).add(new JLabel("Nombre d'étudiant de la classe : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(strength, gbc);

		gbc.gridy = 40;
		P0.getPanelSet(0).add(addBtn, gbc);
		gbc.gridx = 20;
		P0.getPanelSet(0).add(createBtn, gbc);
		gbc.gridx = 30;
		P0.getPanelSet(0).add(showBtn, gbc);

		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				gname.setText("");
				strength.setText("");
				if (createBtn.getText().equals("Créer Groupe")) {
					gPanel.setVisible(true);
					jcbStud.setVisible(true);
					gname.setVisible(true);
					name.setVisible(false);
					createBtn.setText("Annuler");
					addBtn.setText("Ajouter Groupe");
				} else if (createBtn.getText().equals("Annuler")) {
					addBtn.setText("Ajouter Classe");
					createBtn.setText("Créer Groupe");
					gPanel.setVisible(false);
					jcbStud.setVisible(false);
					gname.setVisible(false);
					name.setVisible(true);
				}
			}
		});

		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshTable(P0,DataSet.STUDENT, studnames);
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addBtn.getText().equals("Ajouter Classe")) {
					if (!(P0.validate(name, 0) && P0.validate(strength, 0))) {
						JOptionPane.showMessageDialog(null,"Remplissez les champs!", "Vide",JOptionPane.INFORMATION_MESSAGE);
					} else if (!P0.validate(strength, 1)) {
						JOptionPane.showMessageDialog(null,"Le champ doit être un entier!", "Entier",JOptionPane.ERROR_MESSAGE);
					} else {
						getTTGSData().addStudent(name.getText(),Integer.parseInt(strength.getText()));
						name.setText("");
						strength.setText("");
					}
				} else if (addBtn.getText().equals("Ajouter Groupe")) {
					if (!(P0.validate(name, 0) && P0.validate(gname, 0) && P0.validate(strength, 0))) {
						JOptionPane.showMessageDialog(null,"Ajouter les champs!", "Empty",JOptionPane.INFORMATION_MESSAGE);
					} else if (!P0.validate(strength, 1)) {
						JOptionPane.showMessageDialog(null,"Le champ doit être un entier!", "Number",JOptionPane.ERROR_MESSAGE);
					} else {
						if (getTTGSData().addGroup(name.getText(),gname.getText(),Integer.parseInt(strength.getText()))) {
							name.setText("");
							gname.setText("");
							strength.setText("");

							addBtn.setText("Ajouter Classe");
							createBtn.setText("Créer Groupe");
							gPanel.setVisible(false);
							jcbStud.setVisible(false);
							gname.setVisible(false);
							name.setVisible(true);
						}
					}
				}
				RefreshTable(P0,DataSet.STUDENT, studnames);
			}
		});
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editBtn.getText().equalsIgnoreCase("Modifier Classe")) {
					if (tableView.getSelectedRow() != -1) {
						EditRow(tableView.getSelectedRow());
						editBtn.setText("Enregistrer");
						addBtn.setEnabled(false);
						JOptionPane.showMessageDialog(null,"Vous avez sélectionné la ligne[" + tableView.getSelectedRow() + "] de " + tableView.getName(),"Modifier", JOptionPane.INFORMATION_MESSAGE);
					} else
						JOptionPane.showMessageDialog(null,"Premièrement, vous devez selectionner ", "Modifier",JOptionPane.INFORMATION_MESSAGE);
				} else if (editBtn.getText().equalsIgnoreCase("Enregistrer")) {
					if (tableView.getSelectedRow() != -1) {
						if (SaveRow(tableView.getSelectedRow())) {
							RefreshTable(P0,DataSet.STUDENT, studnames);
							editBtn.setText("Modifier Classe");
							addBtn.setEnabled(true);
							JOptionPane.showMessageDialog(null,"Ligne enregistrée avec succès[" + tableView.getSelectedRow() + "] de " + tableView.getName(),"Enregistrer", JOptionPane.INFORMATION_MESSAGE);
						}
					} else
						JOptionPane.showMessageDialog(null,"Premièrement, vous devez faire une sélection ", "Enregistrer",JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableView.getSelectedRow() != -1) {
					String tmp = tableView.getValueAt(tableView.getSelectedRow(), 0).toString();
					if (RemoveStudent(tableView.getSelectedRow(), tmp)) {
						RefreshTable(P0,DataSet.STUDENT, studnames);
						JOptionPane.showMessageDialog(null,"Ligne enlevée avec succès " + tmp + " de " + tableView.getName(),"Enlever", JOptionPane.INFORMATION_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(null,"Premièrement, vous devez selectionner une ligne ", "Enlever",JOptionPane.INFORMATION_MESSAGE);
			}

			private boolean RemoveStudent(int index, String tmp) {
				String str = tmpList.get(index);
				if (str.indexOf(":") > 0) {
					int i = Integer.parseInt(str.substring(0, str.indexOf(":")));
					int j = Integer.parseInt(str.substring(str.indexOf(":") + 1));
					if (JOptionPane.showConfirmDialog(null, "Voulez vous supprimer une ligne? " + tmp) == JOptionPane.YES_OPTION) {
						getTTGSData().removeGroup(i, j);
						return true;
					}
				} else {
					int i = Integer.parseInt(str);
					if (JOptionPane.showConfirmDialog(null, "Suppression " + tmp + " entraine la destruction de son groupe & "	+ getTTGSData().getStudent(i).getName() + "\n Voulez vous enlever un élément sur la ligne ? " + tmp) == JOptionPane.YES_OPTION) {
						getTTGSData().removeStudent(i);
						return true;
					}
				}
				return false;
			}
		});
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editBtn.setText("Modifier Classe");
				addBtn.setEnabled(true);
			}
		});

		commonListDisplay.setText("");
		P0.getPanelSet(2).add(new JScrollPane(commonList), BorderLayout.CENTER);
		P0.getPanelSet(2).add(new JScrollPane(commonListDisplay),BorderLayout.LINE_END);

		return P0.addPanelSet(title);

	}

	public JPanel getRoomContent(String title) {
		final ShowHidePanel P0 = new ShowHidePanel();
		
		final JComboBox jcbATag = new JComboBox();
		jcbATag.setModel(new DefaultComboBoxModel(new String[] { "Sélectionner Salle", "SALLE", "LAB0"}));
		
		jcbATag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!jcbATag.getSelectedItem().toString().contains("Salle"))
					type.setText(jcbATag.getSelectedItem().toString());
				else 
					type.setText("");
			}
		});
		
		P0.getPanelSet(0).setLayout(new GridBagLayout());
		P0.getPanelSet(1).setLayout(new BorderLayout());
		P0.getPanelSet(2).setLayout(new BorderLayout(10, 10));
		P0.getPanelSet(2).setBorder(new TitledBorder(title + " Liste : "));
		cancelBtn = new JButton("Annuler");

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2);
		gbc.anchor = GridBagConstraints.LINE_END;

		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// Room
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		P0.getPanelSet(3).setLayout(new GridBagLayout());
		addBtn = new JButton("Ajouter Salle");
		editBtn = new JButton("Modifier Salle");
		removeBtn = new JButton("Enlever Salle");
		showBtn = new JButton("Afficher");
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		P0.getPanelSet(3).add(editBtn, gbc);
		gbc.gridx = 10;
		P0.getPanelSet(3).add(removeBtn, gbc);
		gbc.gridx = 20;
		P0.getPanelSet(3).add(cancelBtn, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		P0.getPanelSet(0).add(new JLabel("Nom Salle : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(name, gbc);

		gbc.gridx = 1;
		gbc.gridy = 10;
		P0.getPanelSet(0).add(new JLabel("Type Salle : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(jcbATag, gbc);

		gbc.gridx = 1;
		gbc.gridy = 20;
		P0.getPanelSet(0).add(new JLabel("Capacité Salle : "), gbc);
		gbc.gridx = 10;
		P0.getPanelSet(0).add(capacity, gbc);
		gbc.gridy = 40;
		P0.getPanelSet(0).add(addBtn, gbc);
		gbc.gridx = 20;
		P0.getPanelSet(0).add(showBtn, gbc);

		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshTable(P0,DataSet.ROOM, roomnames);
			}
		});
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(P0.validate(name, 0) && P0.validate(type, 0) && P0.validate(capacity, 0))) {
					JOptionPane.showMessageDialog(null, "Remplir les champs vides!","Vide", JOptionPane.INFORMATION_MESSAGE);
				} else if (!P0.validate(capacity, 1)) {
					JOptionPane.showMessageDialog(null, "le champ est un entier!","Nombre", JOptionPane.ERROR_MESSAGE);
				} else {
					getTTGSData().addRoom(name.getText(),Integer.parseInt(capacity.getText()),type.getText());
				}
				RefreshTable(P0,DataSet.ROOM, roomnames);
			}
		});
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editBtn.getText().equalsIgnoreCase("Modifier Classe")) {
					if (tableView.getSelectedRow() != -1) {
						EditRow(tableView.getSelectedRow());
						editBtn.setText("Enregistrer");
						addBtn.setEnabled(false);
						JOptionPane.showMessageDialog(null,"Vous devez selectionner une ligne[" + tableView.getSelectedRow() + "] de " + tableView.getName(),"Modifier", JOptionPane.INFORMATION_MESSAGE);
					} else
						JOptionPane.showMessageDialog(null,"Premièrement, vous devez selectionner ", "Modifier",JOptionPane.INFORMATION_MESSAGE);
				} else if (editBtn.getText().equalsIgnoreCase("Enregistrer")) {
					if (tableView.getSelectedRow() != -1) {
						if (SaveRow(tableView.getSelectedRow())) {
							RefreshTable(P0,DataSet.ROOM, roomnames);
							editBtn.setText("Modifier Classe");
							addBtn.setEnabled(true);
							JOptionPane.showMessageDialog(null,"Ligne enregistrée avec succès[" + tableView.getSelectedRow() + "] de " + tableView.getName(),"Enregistrer", JOptionPane.INFORMATION_MESSAGE);
						}
					} else
						JOptionPane.showMessageDialog(null,"Premièrement, vous devez selectionner ", "Enregistrer",JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableView.getSelectedRow() != -1) {
					String tmp = tableView.getValueAt(tableView.getSelectedRow(), 0).toString();
					if (JOptionPane.showConfirmDialog(null,"Voulez vous retirer une ligne? " + tmp) == JOptionPane.YES_OPTION) {
						getTTGSData().removeRoom(tableView.getSelectedRow());
						RefreshTable(P0,DataSet.ROOM, roomnames);
						JOptionPane.showMessageDialog(null,"Ligne supprimée avec succès " + tmp + " de " + tableView.getName(), "Supprimer",JOptionPane.INFORMATION_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(null,"Premièrement, vous devez selectionner ", "Supprimer",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editBtn.setText("Modifier Salle");
				addBtn.setEnabled(true);
			}
		});
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		commonListDisplay.setText("");
		P0.getPanelSet(2).add(new JScrollPane(commonList), BorderLayout.CENTER);
		P0.getPanelSet(2).add(new JScrollPane(commonListDisplay),BorderLayout.LINE_END);

		return P0.addPanelSet(title);

	}

	protected void EditRow(int row) {
		if (tableView.getName().equalsIgnoreCase("Enseignant")) {
			name.setText(tableView.getModel().getValueAt(row, 0).toString());
			type.setText(tableView.getModel().getValueAt(row, 1).toString());
		} else if (tableView.getName().equalsIgnoreCase("Classe")) {
			String str = tmpList.get(row);
			if (str.indexOf(":") > 0) {
				int i = Integer.parseInt(str.substring(0, str.indexOf(":")));
				jcbStud.setSelectedIndex(i+1);
				gname.setText(tableView.getModel().getValueAt(row, 0).toString());
				gPanel.setVisible(true);
				jcbStud.setVisible(true);
				gname.setVisible(true);
				name.setVisible(false);
			} else {
				name.setText(tableView.getModel().getValueAt(row, 0).toString());
				gPanel.setVisible(false);
				jcbStud.setVisible(false);
				gname.setVisible(false);
				name.setVisible(true);
			}
			strength.setText(tableView.getModel().getValueAt(row, 1).toString());
		} else if (tableView.getName().equalsIgnoreCase("Cours")) {
			name.setText(tableView.getModel().getValueAt(row, 0).toString());
			tppw.setText(tableView.getModel().getValueAt(row, 1).toString());
			pppw.setText(tableView.getModel().getValueAt(row, 2).toString());
		} else if (tableView.getName().equalsIgnoreCase("Salle")) {
			name.setText(tableView.getModel().getValueAt(row, 0).toString());
			type.setText(tableView.getModel().getValueAt(row, 1).toString());
			capacity.setText(tableView.getModel().getValueAt(row, 2).toString());
		}

	}

	protected boolean SaveRow(int row) {
		String dup = "";
		if (tableView.getName().equalsIgnoreCase("Enseignant")) {
			if (getTTGSData().searchTeacher(name.getText())==row ||
				getTTGSData().searchTeacher(name.getText())==-1) {
				getTTGSData().getTeacher(row).setName(name.getText());
				getTTGSData().getTeacher(row).setType(type.getText());
			} else
				dup = "Entrée dupliquée pour " + name.getText();
		} else if (tableView.getName().equalsIgnoreCase("Classe")) {
			String str = tmpList.get(row);
			if (str.indexOf(":") > 0) {
				int i = Integer.parseInt(str.substring(0, str.indexOf(":")));
				int j = Integer.parseInt(str.substring(str.indexOf(":") + 1));
				if (getTTGSData().searchGroupStudent(i,gname.getText())==j ||
					getTTGSData().searchGroupStudent(i,gname.getText())==-1) {
					getTTGSData().getStudent(i).setGroupName(j, gname.getText());
					getTTGSData().getStudent(i).setGroupSize(j, 
							Integer.parseInt(strength.getText()));
				} else
					dup = "Entrée dupliquée pour " + name.getText();
			} else {
				int i = Integer.parseInt(str);
				if (getTTGSData().searchStudent(name.getText())==i ||
					getTTGSData().searchStudent(name.getText())==-1) {
					getTTGSData().getStudent(i).setName(name.getText());
					getTTGSData().getStudent(i).setTotStud(
							Integer.parseInt(strength.getText()));
				} else
					dup = "Entrée dupliquée pour " + name.getText();
			}
			
			
		} else if (tableView.getName().equalsIgnoreCase("Cours")) {
			if (getTTGSData().searchTeacher(name.getText())==row ||
				getTTGSData().searchSubject(name.getText())==-1) {
				getTTGSData().getSubject(row).setName(name.getText());
				getTTGSData().getSubject(row).setTPPW(Integer.parseInt(tppw.getText()));
				getTTGSData().getSubject(row).setPPPW(Integer.parseInt(pppw.getText()));
			} else
				dup = "Entrée dupliquée pour " + name.getText();
		} else if (tableView.getName().equalsIgnoreCase("Salles")) {
			if (getTTGSData().searchTeacher(name.getText())==row ||
				getTTGSData().searchRoom(name.getText())==-1) {
				getTTGSData().getRoom(row).setName(name.getText());
				getTTGSData().getRoom(row).setType(type.getText());
				getTTGSData().getRoom(row).setCapacity(
						Integer.parseInt(capacity.getText()));
			} else
				dup = "Entrée dupliquée pour" + name.getText();
		}

		if (!dup.equals("")) {
			JOptionPane.showMessageDialog(null, dup, "Dupliqué",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			tableView.clearSelection();

		return true;
	}

	@SuppressWarnings( { "serial" })
	public void createTable(int c, final String[] names) {
		String tableViewName = "";
		dataTable.clear();

		switch (c) {
		case DataSet.SUBJECT:
			tableViewName="COURS";
			for (int i = 0; i < getTTGSData().getSubjectLength(); i++)
				dataTable.add(getTTGSData().getSubjectRecord(i));
			break;
		case DataSet.STUDENT:
			tableViewName="ETUDIANT";
			for (int i = 0; i < getTTGSData().getStudentLength(); i++) {
				dataTable.add(getTTGSData().getStudentRecord(i));
				for (int j = 0; j < getTTGSData().getStudent(i).getGroupList().size(); j++)
					dataTable.add(getTTGSData().getGroupStudentRecord(i, j));
			}
			break;
		case DataSet.TEACHER:
			tableViewName="ENSEIGNANT";
			for (int i = 0; i < getTTGSData().getTeacherLength(); i++)
				dataTable.add(getTTGSData().getTeacherRecord(i));
			break;
		case DataSet.ROOM:
			tableViewName="SALLE";
			for (int i = 0; i < getTTGSData().getRoomLength(); i++)
				dataTable.add(getTTGSData().getRoomRecord(i));
			break;
		}

		// final
		// Create a model of the data.
		TableModel dataModel = new AbstractTableModel() {

			public int getColumnCount() {
				return names.length;
			}

			public int getRowCount() {
				return dataTable.size();
			}

			public Object getValueAt(int row, int col) {
				return dataTable.get(row)[col];
			}

			public String getColumnName(int column) {
				return names[column];
			}

			@SuppressWarnings("unchecked")
			public Class getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}

			public boolean isCellEditable(int row, int col) {
				return col == -1;
			}

			public void setValueAt(Object aValue, int row, int column) {
				dataTable.get(row)[column] = aValue;
			}
		};

		// Create the table
		tableView = new JTable(dataModel);
		tableView.setRowHeight(INITIAL_ROWHEIGHT);
		tableView.setName(tableViewName);

		scrollpane = new JScrollPane(tableView);
		tableAggregate = scrollpane;
		updateData(c);
	}

	public void updateData(int c) {
		dataList.clear();
		tmpList.clear();
		commonList.removeAll();
		
		switch (c) {
		case DataSet.SUBJECT:
			for (int i = 0; i < getTTGSData().getSubjectLength(); i++)
				dataList.add(i, i + "]" + getTTGSData().getSubject(i).getName());
			break;
		case DataSet.STUDENT:
			jcbStud.removeAllItems();
			jcbStud.updateUI();
			if (getTTGSData().getStudentLength() == 0)
				jcbStud.addItem("Pas de classe");
			else
				jcbStud.addItem("Sélectionner une classe");

			for (int i = 0; i < getTTGSData().getStudentLength(); i++)
				jcbStud.addItem(getTTGSData().getStudent(i).getName());

			for (int i = 0,k=0; i < getTTGSData().getStudentLength(); i++) {
				String s = getTTGSData().getStudent(i).getName();
				int size=getTTGSData().getStudent(i).getGroupList().size();
				tmpList.add(String.valueOf(i));
				dataList.add(k++,"Class:"+ (i+1) + " " +s);
				for (int j = 0; j < size ; j++) {
					tmpList.add(String.valueOf(i) + ":" + String.valueOf(j));
					dataList.add(k++, "Batch:"+ (j+1) + " " + getTTGSData().getStudent(i).getGroupName(j));
				}
			}
			break;
		case DataSet.TEACHER:
			for (int i = 0; i < getTTGSData().getTeacherLength(); i++)
				dataList.add(i, i + "]" + getTTGSData().getTeacher(i).getName());
			break;
		case DataSet.ROOM:
			for (int i = 0; i < getTTGSData().getRoomLength(); i++)
				dataList.add(i, i + "]" + getTTGSData().getRoom(i).getName());
			break;
		}
		
		commonList.setListData(dataList);
		commonList.updateUI();
	}
}
