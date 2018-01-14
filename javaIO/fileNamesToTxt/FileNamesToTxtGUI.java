package katrenich.javaIO.fileNamesToTxt;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.List;

/**
 * Клас описує графічний інтерфейс додатку для запису назв директорій та файлів в текстовий документ
 */
public class FileNamesToTxtGUI extends JFrame{
	private JButton buttonGo = new JButton("Write file names");
	private JButton buttonDir = new JButton("...");
	private JLabel srcDirLabel = new JLabel("Chose source directory");
	private JTextField dirAbsPath = new JTextField(15);
	private JCheckBox filesIncludes = new JCheckBox("Only directories", false);
	private JFileChooser fileChooser = null;

//	private JFileChooser getDir = new JFileChooser();

	public FileNamesToTxtGUI(){
		super("Directory names getter");
		this.setBounds(200,200, 400, 150);
//		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		JPanel panel = new JPanel(new FlowLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel(new FlowLayout());

		this.add(panel, BorderLayout.NORTH);
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);

		buttonDir.setPreferredSize(new Dimension(19,19));

		panel.add(srcDirLabel);
		panel.add(buttonDir);
		panel.add(dirAbsPath);
		panel1.add(filesIncludes);
		panel2.add(buttonGo);

		fileChooser = new JFileChooser();
		addFileChooserListeners();
	}


	private void addFileChooserListeners() {
		buttonDir.addActionListener(event -> {
			//Визначення режима "Тільки директорія"
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int ref = fileChooser.showDialog(this.fileChooser, "Chose directory");
			if(ref == JFileChooser.APPROVE_OPTION){
				File srcDir = fileChooser.getSelectedFile();
				dirAbsPath.setText(srcDir.getAbsolutePath());
			}
		});

		buttonGo.addActionListener(event -> {
			boolean includeFiles = filesIncludes.isSelected();
			File dir = new File(dirAbsPath.getText());
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT", "*.*");
			List<String> list;
			File dest = null;

			if(dir.exists()){
				list = FileNamesToTxt.getNameFiles(dir, !includeFiles);

				fileChooser.setDialogTitle("Save file");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setFileFilter(filter);

				int result = fileChooser.showSaveDialog(this);
				if(result == JFileChooser.APPROVE_OPTION){
					dest = fileChooser.getSelectedFile();
					if(!dest.getName().endsWith(".txt")){
						dest = new File(dest.getAbsolutePath() + ".txt");
					}

					try {
						FileNamesToTxt.writeOnFile(dest, list);
						JOptionPane.showMessageDialog(this, "It`s done!", "OK!", 1);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(this, e, "Error", 0);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Please chose the directory!", "Error", 0);
			}

		});
	}

}
