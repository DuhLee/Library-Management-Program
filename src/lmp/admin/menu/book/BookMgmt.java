package lmp.admin.menu.book;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BookMgmt extends JFrame{
    // 이미지 추가. 메인메서드 밖에 위치.
    Image img = Toolkit.getDefaultToolkit().getImage(
    "C:\\JavaFullStack\\repository\\Library_Management_Program\\src\\lmp\\admin\\menu\\book\\images\\books.jpg");
       public BookMgmt() throws IOException {
          this.setContentPane(new JPanel() {
             @Override
             public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                g.drawImage(img, 110, 100, null);
                setOpaque(false);
             }
          });
          pack();
          setVisible(true);
       }

 public static void main(String[] args) throws IOException {
       
    // 메인 프레임 선언
    JFrame frame = new BookMgmt();
    frame.setTitle("Library - Mangement - Program");
    frame.setLayout(null);

    // 패널의 열 수는 검색된 정보 수에 따라 다르게 설정 가능
          String[] category = {"제목","저자","출판사","ISBN","편권수","복권수","등록일","가격","위치","비고"};
          String[][] contents = {      
                {"노인과 바다", "어니스트 헤밍웨이", "타임주니어", "9788928637843", "1","1","2017/01/20","12000","토평아동실"," "},
                {"노인과 바다", "어니스트 헤밍웨이", "빈빈책방", "9791196278045", "1","1","2018/01/22","11000","토평아동실"," "},
                {"노인과 바다 : 어니스트 헤밍웨이 소설", "어니스트 헤밍웨이", "문학동네", "9788954609012", "1","1","2012/01/20","8000","토평종합자료실"," "},
                {"어린왕자", "생텍쥐페리", "한국몬테소리", "8983112565", "1","1","2002/01/25","10840","토평보존서고"," "},
                {"어린왕자", "앙투안 드 생텍쥐페리", "노마드", "9791186288139", "1","1","2015/01/25","12000","토평종합자료실"," "},
                {"죄와 벌. 1", "표도르 도스토옙스키", "문학동네", "9788954671774", "1","1","2020/01/10","13500","토평종합자료실"," "},
                {"죄와 벌. 2", "표도르 도스토옙스키", "문학동네", "9788954671781", "1","1","2020/01/10","13500","토평종합자료실"," "},
                {"죄와 벌", "도스토예프스키", "지경사", "9788931911534", "1","1","2021/01/12","5500","토평아동실"," "},
                {"템테이션", "더글라스 케네디", "밝은세상", "9788984371170", "1","1","2012/01/02","13500","토평종합자료실"," "},
                {"상실의 시대", "무라카미 하루키", "문학사상사", "8970123695", "1","1","2000/01/20","7800","토평보존서고"," "},
                {"상실의 시대 : 무라카미 하루키 장편소설", "무라카미 하루키 ", "문학사상사", "9788970123691", "1","1","2009/01/02","15000","토평종합자료실"," "},                
          };
    // 도서현황 검색 창 초기화면 테이블      
    JTable table = new JTable(new String[50][category.length], category);
    JScrollPane scroll = new JScrollPane(table);
    table.getColumnModel().getColumn(0).setMinWidth(800);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    scroll.setBounds(0, 250, 1185, 500);
    frame.add(scroll);
    // 도서검색 라벨 선언
    JLabel label = new JLabel("도서검색 : ");
    label.setBounds(10, 200, 100, 35);   
    label.setFont(new Font("고딕체", Font.BOLD, 18));
    frame.add(label);      
    // 도서검색 창 메인 패널 선언
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBounds(105, 200, 400, 35);
    panel.setBorder(new LineBorder(Color.BLACK));
    frame.add(panel);      
    // 도서검색 콤보박스 선언
    JComboBox cb = new JComboBox(category);
    cb.setBounds(0, 0, 100, 35);
    cb.setFont(new Font("고딕체", Font.BOLD, 15));
    // 도서검색 텍스트필드 선언
    JTextField textF = new JTextField(" 검색어를 입력하세요.");
    // 텍스트필드 옆 검색 버튼 선언
    JButton button = new JButton("검 색");   
    
    textF.setBounds(100, 0, 220, 35);
    textF.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {   // 텍스트필드 안에서 검색어 입력 후 Enter 치면 검색버튼 클릭효과와 동일하게 작동지시
          button.doClick();
       }         
    });
    textF.addMouseListener(new MouseAdapter() {      // 검색 텍스트필드 안에 마우스 클릭 시 안내문구 삭제
       @Override
       public void mouseClicked(MouseEvent e) {
          textF.setText("");
       }
    });
    textF.setBounds(100, 0, 220, 35);
    textF.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {   // 검색버튼 클릭 시 작동기능
          button.doClick();
       }         
    });
    button.setBounds(320, 0, 80, 35);
    button.setFont(new Font("고딕체", Font.BOLD, 18));
    button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             String[][] valid = new String[30][6];
             int index = 0;
             for (int i = 0; i < contents.length; ++i) {
                if (contents[i][cb.getSelectedIndex()].contains(textF.getText())) {
                   valid[index++] = contents[i];
                }
             }
             JScrollPane result = new JScrollPane(new JTable(valid, category));
             result.setBounds(0, 250, 1100, 60);
             frame.add(result);
             frame.validate();
             textF.setText("");
          }
       });
          
    JOptionPane op = new JOptionPane();
    
    // 정보수정 버튼 선언
    JButton update = new JButton("정보수정");
    update.setBounds(830, 200, 100, 35);
    update.setFont(new Font("고딕체", Font.BOLD, 16));
    update.setBackground(Color.DARK_GRAY);
    update.setForeground(Color.WHITE);
    update.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(frame, "정보수정 완료.");
       }         
    });
    frame.add(update);
    // 내용삭제 버튼 선언
    JButton delete = new JButton("내용삭제");
    delete.setBounds(940, 200, 100, 35);
    delete.setFont(new Font("고딕체", Font.BOLD, 16));
    delete.setBackground(Color.RED);
    delete.setForeground(Color.WHITE);
    delete.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(frame, "선택한 도서의 정보를 삭제합니다. 다시 되돌릴 수 없습니다.");
       }         
    });
    frame.add(delete);
    // 도서등록 버튼 선언
    
    JButton registration = new JButton("도서등록");
    registration.setBounds(1050, 200, 100, 35);
    registration.setFont(new Font("고딕체", Font.BOLD, 16));
    registration.setBackground(Color.cyan);
    //registration.setForeground(Color.WHITE);
    registration.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
          //JOptionPane.showMessageDialog(frame, "도서등록 화면으로 이동합니다.");
          //new BookRegistration();
          new BookRegist("도서등록 화면");
       }         
    });
    frame.add(registration);
          
    panel.add(cb);      
    panel.add(textF);      
    panel.add(button);
    
    frame.setBounds(300, 100, 1200, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);      
 }
}