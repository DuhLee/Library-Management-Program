package lmp.admin.menu.readingroom.usagelist.label;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import lmp.admin.AdminFrame;
import lmp.admin.menu.readingroom.ReadingRoomPanel;
import lmp.admin.menu.readingroom.seatlist.SeatListPanel;
import lmp.admin.menu.readingroom.seatlist.panel.SeatPanel;
import lmp.admin.menu.readingroom.seatlist.panel.StatusPanel;
import lmp.admin.menu.readingroom.usagelist.UsageListPanel;
import lmp.admin.menu.readingroom.usagelist.scrollpane.UsageListScrollPane;
import lmp.admin.menu.readingroom.usagelist.scrollpane.table.UsageListTable;
import lmp.db.dao.ReadingRoomDao;
import lmp.db.dao.SeatUseDetailDao;
import lmp.db.vo.SeatUseDetailVO;

public class UsageListCheckOutButton extends JPanel {
	
	SeatUseDetailDao sudDao = new SeatUseDetailDao();
	ReadingRoomDao roomDao = new ReadingRoomDao();
	ArrayList<SeatUseDetailVO> sudList =  new ArrayList<>();
	
	// 강제퇴실, 새로고침 버튼 패널
	public UsageListCheckOutButton(ReadingRoomPanel readingRoomPanel) {
		
		this.setLayout(new GridLayout(1, 2));
		this.setBackground(readingRoomPanel.getBackground());
		
		SeatListPanel  seatListPanel = readingRoomPanel.getSeatListPanel();
		UsageListPanel usageListPanel = readingRoomPanel.getUsageListPanel();
		UsageListTable usageListTable = readingRoomPanel.getUsageListScrollPane().getUsageListTable();
		
		JButton refreshButton = AdminFrame.getButton("");
		try {
			BufferedImage buffer = ImageIO.read(new File("src/lmp/admin/menuButtonImages/refreshIcon.png"));
			Image image = buffer.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			refreshButton.setIcon(new ImageIcon(image));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sudList.clear();
					sudList.addAll(sudDao.get()); // DB 내용 가져오기
					DefaultTableModel model = readingRoomPanel.getUsageListScrollPane().getModel();
					
					int totalSeat = roomDao.get().size();
					
					model.setRowCount(0);
					model.setRowCount(totalSeat);
					
					int resetRow = 0;
					for (SeatUseDetailVO sud : sudList) {
							
						for (int i = 0; i < sud.getSudList().length; i++) {
							if (i == 5) {
								if (sud.getMember().getSex().equals("0")) {
									model.setValueAt("남", resetRow, i);
								} else {						
									model.setValueAt("여", resetRow, i);
								}
							} else {
								model.setValueAt(sud.getSudList()[i], resetRow, i);
							}
						}
						resetRow++;
					}
					
					usageListTable.setModel(model);
					
					usageListTable.validate(); // 새로고침 - 버튼 액션으로
					
					seatListPanel.refresh(sudList);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton checkOutButton = new JButton("강제퇴실");
		checkOutButton.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15));
		checkOutButton.setBackground(new Color(227, 94, 79));
		checkOutButton.setForeground(Color.WHITE);
		
		checkOutButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// 테이블에 선택한 값이 없는 경우
				if (usageListTable.getSelectedRow() != -1) {
					
					if (usageListTable.getValueAt(usageListTable.getSelectedRow(), 0) != null) {
						int result = JOptionPane.showConfirmDialog(usageListPanel, "해당 사용자를 퇴실처리 하시겠습니까?", "강제퇴실 확인",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION) {
							return;
						} else {
							
							int selectRow = usageListTable.getSelectedRow();// 선택된 테이블의 행값
							Integer seat_num = (int) usageListTable.getValueAt(selectRow, 0);

							if (seat_num != null) {
								try {
									sudDao.update(seat_num);
								} catch (SQLException e2) {
									e2.printStackTrace();
								}

								// --------- 데이터베이스 수정하기 ---------

								try {
									sudList.clear();
									sudList.addAll(sudDao.get()); // DB 내용 가져오기
									DefaultTableModel model = readingRoomPanel.getUsageListScrollPane().getModel();

									int totalSeat = roomDao.get().size();
									
									model.setRowCount(0);
									model.setRowCount(totalSeat);
									
									int resetRow = 0;
									for (SeatUseDetailVO sud : sudList) {
										
										for (int i = 0; i < sud.getSudList().length; i++) {
											if (i == 5) {
												if (sud.getMember().getSex().equals("0")) {
													model.setValueAt("남", resetRow, i);
												} else {						
													model.setValueAt("여", resetRow, i);
												}
											} else {
												model.setValueAt(sud.getSudList()[i], resetRow, i);
											}
										}
										resetRow++;
									}

									usageListTable.setModel(model);

									usageListTable.validate(); // 새로고침 - 버튼 액션으로

									seatListPanel.refresh(sudList);
									
									
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(usageListTable, "퇴실할 좌석을 선택해 주세요");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(usageListTable, "퇴실할 좌석을 선택해 주세요");
					return;
				}
			}
		});
		
		this.add(refreshButton);
		this.add(checkOutButton);
	}
}
