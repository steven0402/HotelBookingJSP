package hotel.pages;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import hotel.user.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SearchingResultPage{
	private String indate;
	private String outdate;
	private int singleroom;
	private int doubleroom;
	private int quadroom;
	private Query A;
	public int nowPage;
	private int star;
	
	public SearchingResultPage(String indate, String outdate, int singleroom, int doubleroom, int quadroom, int star){
		this.indate = indate;
		this.outdate = outdate;
		this.singleroom = singleroom;
		this.doubleroom = doubleroom;
		this.quadroom = quadroom;
		this.star = star;
		this.A = new Query(this.singleroom, this.doubleroom, this.quadroom, this.indate, this.outdate, this.star);
		this.nowPage = 0;
	}
	public int SetTable(JPanel resultpanel){
		ArrayList<QueryResult> resultList = this.A.searchRoom(nowPage);
		
		String[] tabletitle = {"HOTEL_ID", "STAR", "ONE_ADULT", "TWO_ADULTS", "FOUR_ADULTS", "TOTAL_PRICE"};
		Object [][]data = {};
		JTable showTable = new JTable(data,tabletitle);
		showTable.setPreferredScrollableViewportSize(new Dimension(400,300));
		showTable.setModel(new DefaultTableModel(data,tabletitle));
		JScrollPane tableContainer = new JScrollPane(showTable);
		DefaultTableModel TableModel = (DefaultTableModel)showTable.getModel();
		
		resultpanel.add(tableContainer,BorderLayout.CENTER);
		int itemcount = 0;
		
		for(QueryResult r : resultList){
			TableModel.addRow(new Object[]{r.hotel_id,r.star,r.one_adult,r.two_adults,r.four_adults,r.total_price});
			itemcount += 1;
		}
		if(itemcount > 0) TableModel.removeRow(0);
		
		return itemcount;
	}
    public void createresultGUI(){

        JFrame.setDefaultLookAndFeelDecorated(true);


        JFrame resultframe = new JFrame("SearchingResult");
		resultframe.setSize(500,550);
        resultframe.setVisible(true);

        JPanel resultpanel = new JPanel();
		
		resultframe.add(resultpanel,BorderLayout.CENTER);
		
		resultpanel.setLayout(new BorderLayout());
		
		JLabel ResultnameLabel = new JLabel("The Result:");
		//ResultnameLabel.setBounds(65,70,180,25);
		resultframe.add(ResultnameLabel,BorderLayout.NORTH);
		
		int itemnumber = SetTable(resultpanel);
        resultpanel.add(new JLabel(String.valueOf(nowPage+1)),BorderLayout.SOUTH);
		
        JButton backButton = new JButton("Return");
		JButton nextButton = new JButton("Next Page");
		JButton previousButton = new JButton("Previous Page");	
		JButton bookButton = new JButton("Start Booking");		
		JPanel btnPanel = new JPanel();
		
        backButton.setPreferredSize(new Dimension(115, 25));
        nextButton.setPreferredSize(new Dimension(115, 25));
		previousButton.setPreferredSize(new Dimension(115, 25));
		bookButton.setPreferredSize(new Dimension(115, 25));
		btnPanel.add(backButton);
		btnPanel.add(previousButton);
		btnPanel.add(nextButton);
		btnPanel.add(bookButton);
		
        resultframe.add(btnPanel,BorderLayout.SOUTH);
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				resultframe.dispose();
				TitlePage newtitle = new TitlePage();
				newtitle.createTitleGUI();
			}
		});
		previousButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				resultframe.dispose();
				if (nowPage > 0) nowPage --;
				createresultGUI();
			}
		});
		nextButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				resultframe.dispose();
				if (itemnumber > 0) nowPage += 1;
				createresultGUI();
			}
		});
		bookButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BookingPage bookPage = new BookingPage();
				bookPage.createBookingGUI();
			}
		});
		
    }
	
    public static void main(String[] args) {

		SearchingResultPage resultpage = new SearchingResultPage("2012-01-01","2012-01-03",1,2,3,3);
		resultpage.createresultGUI();

    }
}
