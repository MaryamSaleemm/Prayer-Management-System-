import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Home extends javax.swing.JFrame {

    public Home() {
        HomeScreen();
    }
    private void HomeScreen() {

        jPanel1 = new ImagePanel("src/Assets/bghome.png");

        backButton = new JButton();
        tasbihButton = new JButton();
        rakatChartButton = new JButton();
        prayerTimeButton = new JButton();
        duasButton = new JButton();
        asmaHusnaButton = new JButton();
        surahButton = new JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setSize(1360, 680);
// It disables any debug-related graphics features like highlighting drawing issues or checking for unnecessary painting.
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        backButton.setBackground(new Color(0, 0, 0));
        backButton.setIcon(new ImageIcon("src/Assets/Back Arrow.png")); // NOI18N
        backButton.setBorder(null);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        tasbihButton.setIcon(new ImageIcon("src/Assets/Tasbih.png"));
        tasbihButton.setBorder(null);
        tasbihButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tasbihButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tasbihButtonActionPerformed(evt);
            }
        });
        rakatChartButton.setIcon(new ImageIcon("src/Assets/Namaz.png"));
        rakatChartButton.setBorder(null);
        rakatChartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rakatChartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rakatChartButtonActionPerformed(evt);
            }
        });
        prayerTimeButton.setIcon(new ImageIcon("src/Assets/Prayer.png"));
        prayerTimeButton.setBorder(null);
        prayerTimeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        prayerTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                prayerTimeButtonActionPerformed(evt);
            }
        });
        duasButton.setIcon(new ImageIcon("src/Assets/Dua.png")); // NOI18N
        duasButton.setBorder(null);
        duasButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        duasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                duasButtonActionPerformed(evt);
            }
        });
        asmaHusnaButton.setIcon(new ImageIcon("src/Assets/Asma.png")); // NOI18N
        asmaHusnaButton.setBorder(null);
        asmaHusnaButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        asmaHusnaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                asmaHusnaButtonActionPerformed(evt);
            }
        });
        surahButton.setIcon(new ImageIcon("src/Assets/surah's.png")); // NOI18N
        surahButton.setBorder(null);
        surahButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        surahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                surahButtonActionPerformed(evt);
            }
        });
      //container
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        //horizontally arrange components
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tasbihButton)
                                        .addGap(90, 90, 90)
                                        .addComponent(rakatChartButton))

                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(surahButton)
                                        .addGap(90, 90, 90)
                                        .addComponent(duasButton)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(prayerTimeButton, GroupLayout.Alignment.TRAILING)
                                .addComponent(asmaHusnaButton, GroupLayout.Alignment.TRAILING))
                        .addGap(78, 78, 78))
        );
        //Verticallly align components
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton)
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(rakatChartButton)
                                        .addComponent(prayerTimeButton)
                                        .addComponent(tasbihButton))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(duasButton)
                                        .addComponent(asmaHusnaButton)
                                        .addComponent(surahButton))
                                .addContainerGap(66, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
//Adjusts the size of the JFrame to fit all its components neatly without wasting extra space.
        pack();
    }

    private void tasbihButtonActionPerformed(ActionEvent evt) {
        showTasbihCounterPage();
    }

    private void rakatChartButtonActionPerformed(ActionEvent evt) {
        new NamazRakatChart();
    }

    private void prayerTimeButtonActionPerformed(ActionEvent evt) {
        new TimePrayerTimes();
    }

    private void surahButtonActionPerformed(ActionEvent evt) {
        new Surah();
    }


    private void duasButtonActionPerformed(ActionEvent evt) {
        showDuasPage();
    }

    private void asmaHusnaButtonActionPerformed(ActionEvent evt) {
        showAsmaEHusnaPage();
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        new Registration().setVisible(true);
        // Close the current window
        this.dispose();
    }

    public class Surah extends JFrame {

        public Surah() {
            setTitle("Surah List");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 600);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            JLabel titleLabel = new JLabel("List of Surahs", JLabel.CENTER);
            titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
            titleLabel.setForeground(new Color(0,0,0));
            mainPanel.add(titleLabel, BorderLayout.NORTH);

            JPanel surahPanel = new JPanel();
            surahPanel.setLayout(new GridLayout(0, 5, 5, 5));
            JScrollPane scrollPane = new JScrollPane(surahPanel);
            mainPanel.add(scrollPane, BorderLayout.CENTER);

            try {
                String apiUrl = "https://api.quran.com/api/v4/chapters";
                String response = fetchApiResponse(apiUrl);
                populateSurahButtons(response, surahPanel, this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            add(mainPanel);
            setVisible(true);
        }

        private String fetchApiResponse(String apiUrl) throws Exception {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            } else {
                throw new Exception("HTTP Error: " + responseCode);
            }
        }

        private void populateSurahButtons(String response, JPanel panel, JFrame parentFrame) {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray chapters = jsonResponse.getJSONArray("chapters");

            for (int i = 0; i < chapters.length(); i++) {
                JSONObject chapter = chapters.getJSONObject(i);
                String surahName = chapter.getString("name_simple");
                int surahNumber = chapter.getInt("id");

                JButton surahButton = new JButton(surahNumber + ". " + surahName);
                surahButton.setFont(new Font("SansSerif", Font.BOLD, 16));
                surahButton.setBackground(new Color(255 , 182 ,193));
                surahButton.setSize(30 ,20);
                surahButton.setForeground(Color.BLACK);

                surahButton.addActionListener(e -> showSurahContent(surahNumber, parentFrame));
                panel.add(surahButton);
            }

            panel.revalidate();
            panel.repaint();
        }

        private void showSurahContent(int surahNumber, JFrame parentFrame) {
            JFrame frame = new JFrame("Surah Content");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 600);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            JEditorPane surahPane = new JEditorPane();
            surahPane.setContentType("text/html");
            surahPane.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(surahPane);
            mainPanel.add(scrollPane, BorderLayout.CENTER);

            try {
                String apiUrl = "https://api.quran.com/api/v4/quran/verses/uthmani?chapter_number=" + surahNumber;
                String response = fetchApiResponse(apiUrl);
                String surahText = getSurahText(response);

                String htmlContent = "<html><body style='font-family: Traditional Arabic; font-size: 18px; color: #333; text-align: center;'>" + surahText.replace("\n", "<br>") + "</body></html>";
                surahPane.setText(htmlContent);
            } catch (Exception e) {
                surahPane.setText("<html><body style='color: red;'>Error fetching surah details: " + e.getMessage() + "</body></html>");
            }

            frame.add(mainPanel);
            frame.setVisible(true);
        }

        private String getSurahText(String response) {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray verses = jsonResponse.getJSONArray("verses");

            StringBuilder surahText = new StringBuilder();
            for (int i = 0; i < verses.length(); i++) {
                JSONObject verse = verses.getJSONObject(i);
                surahText.append(verse.getString("text_uthmani")).append("\n");
            }

            return surahText.toString();
        }
    }
    private void showDuasPage() {
        JPanel panel = new JPanel(new BorderLayout());

// JEditorPane is capable of displaying rich text such as HTML
        JEditorPane duasEditorPane = new JEditorPane();
        duasEditorPane.setContentType("text/html");
        duasEditorPane.setBackground(new Color(230, 230, 250));// Set background for the JEditorPane
        duasEditorPane.setSize(840, 650);
        duasEditorPane.setContentType("text/html");
        duasEditorPane.setText("<html>" +
                "<body style='text-align: center; direction: rtl;'>\n" +

                "<h3>UPON GOING TO SLEEP:</h3>\n" +
                "<p>Arabic: <b style='color: blue;'>\u0627\u0644\u0647\u064f\u0645\u064e \u0628\u0650\u0627\u0633\u0652\u0645\u0650\u0643\u064e \u0623\u064e\u0645\u064f\u0648\u062a\u064f \u0648\u064e\u0623\u064e\u062d\u0652\u064a\u064e\u0649</b></p>" +
                "<p>Translation: <b style='color: green;'>O Allah, in Your name, I die and I live.</b></p>" +
                "<p>Reference: <i style='color: gray;'>Sahih Muslim 4/2083 | Fateh Al Bari 11/113</i></p>\n" +

                "<h3>WAKE UP FROM SLEEP:</h3>\n" +
                "<p>Arabic: <b style='color: blue;'>\u0627\u0644\u062d\u064e\u0645\u0652\u062f\u064f \u0644\u0650\u0644\u0647\u0650 \u0627\u0644\u0651\u064e\u0630\u0650\u0649 \u0623\u064e\u062d\u0652\u064a\u064e\u0627\u0646\u064e\u0627 \u0628\u064e\u0639\u0652\u062f\u064e \u0645\u064e\u0627 \u0623\u064e\u0645\u064e\u0627\u062a\u064e\u0646\u064e\u0627 \u0648\u064e\u0625\u0650\u0644\u064e\u064a\u0652\u0647\u0650 \u0627\u0644\u0646\u0651\u064f\u0634\u064f\u0648\u0631</b></p>" +
                "<p>Translation: <b style='color: green;'>All praise be to Allah, who gave us life after death (sleep is a form of death) and to Him will we be raised and returned.</b></p>" +
                "<p>Reference: <i style='color: gray;'>Sahih Muslim 4/2083 | Fateh Al Bari 11/113</i></p>\n" +

                "<h3>START OF WUDU:</h3>\n" +
                "<p>Arabic: <b style='color: blue;'>\u0628\u0650\u0633\u0652\u0645\u0650 \u0627\u0644\u0644\u0651\u064e\u0647\u0650 \u0627\u0644\u0631\u064e\u062d\u0652\u0645\u064e\u0646\u0650 \u0627\u0644\u0631\u064e\u062d\u0650\u064a\u0645</b></p>" +
                "<p>Translation: <b style='color: green;'>In the name of Allah, the Entirely Merciful, the Especially Merciful.</b></p>" +
                "<p>Reference: <i style='color: gray;'>Abu Dawood | Ibn Majah | Imam Ahmed</i></p>\n" +

                "<h3>COMPLETION OF WUDU:</h3>\n" +
                "<p>Arabic: <b style='color: blue;'>\u0623\u064e\u0634\u0652\u0647\u064e\u062f\u064f \u0623\u064e\u0646\u0652 \u0644\u064e\u0627 \u0625\u0650\u0644\u064e\u0647\u064e \u0625\u0650\u0644\u0651\u064e\u0627 \u0627\u0644\u0644\u0651\u0647\u064f \u0648\u064e\u062d\u0652\u062f\u064e\u0647\u064f \u0644\u064e\u0627 \u0634\u064e\u0631\u0650\u064a\u0643\u064f \u0644\u064e\u0647\u064f \u0648\u064e\u0623\u064e\u0634\u0652\u0647\u064e\u062f\u064f \u0623\u064e\u0646\u0651\u064e \u0645\u064f\u062d\u064e\u0645\u0651\u064e\u062f\u064b\u0627 \u0639\u064e\u0628\u0652\u062f\u064f\u0647\u064f \u0648\u064e\u0631\u064e\u0633\u064f\u0644\u064f\u0647</b></p>" +
                "<p>Translation: <b style='color: green;'>I testify that there is no one worthy of worship besides Allah. He is all by Himself and has no partner, and I testify that Muhammad is Allah's messenger (Rasool).</b></p>" +
                "<p>Reference: <i style='color: gray;'>Sahih Muslim 1/209</i></p>\n" +

                "<h3>ENTERING THE MASJID:</h3>\n" +
                "<p>Arabic: <b style='color: blue;'>\u0628\u0650\u0633\u0652\u0645\u0650 \u0627\u0644\u0644\u0651\u064e\u0647\u0650 \u0627\u0644\u0633\u0651\u064e\u0644\u064e\u0627\u0645\u064f \u0639\u064e\u0644\u064e\u064a\u0652\u0643\u064f\u0645\u0652 \u0648\u064e\u0631\u064e\u062d\u0652\u0645\u064e\u0629\u064f \u0627\u0644\u0644\u0651\u0647\u0650 \u0648\u064e\u0628\u064e\u0631\u064e\u0643\u064e\u0627\u062a\u064f\u0647</b></p>" +
                "<p>Translation: <b style='color: green;'>In the Name of Allah, and peace and blessings be upon the Messenger of Allah. O Allah, open the doors of mercy.</b></p>" +
                "<p>Reference: <i style='color: gray;'>Abu Dawood | Ibn As Sunan 888 | Al Albani</i></p>\n" +

                "<h3>LEAVING THE MASJID:</h3>\n" +
                "<p>Arabic: <b style='color: blue;'>\u0628\u0650\u0633\u0652\u0645\u0650 \u0627\u0644\u0644\u0651\u064e\u0647\u0650 \u0627\u0644\u0633\u0651\u064e\u0644\u064e\u0627\u0645\u064f \u062a\u064e\u0645\u0650\u0628\u0652\u0646\u064e \u0625\u0650\u0644\u064e\u0647\u064e \u0623\u064e\u0639\u064f\u0648\u0652\u0630\u064f \u0623\u064e\u0639\u064f\u0623\u0644\u0652\u0643</b></p>" +
                "<p>Translation: <b style='color: green;'>O Allah, I ask You for Your mercy. O Allah, forgive me and have mercy on me.</b></p>" +
                "<p>Reference: <i style='color: gray;'>Abu Dawood | Ibn Majah</i></p>\n" +

                "<h3>ENTERING THE TOILET:</h3>\n" +
                "<p>Arabic: <b style='color: blue;'>\u0628\u0650\u0633\u0652\u0645\u0650 \u0627\u0644\u0644\u0651\u064e\u0647\u0650 \u0627\u0644\u0647\u064f\u0645\u064e \u0625\u0650\u0646\u0651\u0650\u0649 \u0623\u064e\u0639\u064f\u0648\u0652\u0630\u064f \u0628\u0650\u0643\u064e \u0645\u0650\u0646\u0652 \u0627\u0644\u062e\u064f\u0628\u064f\u062b\u0650 \u0648\u064e\u0627\u0644\u062e\u064e\u0628\u064e\u0627\u0626\u0650\u062b</b></p>" +
                "<p>Translation: <b style='color: green;'>In the name of Allah. O Allah, I seek refuge in You from the male and female evil and Jinns.</b></p>" +
                "<p>Reference: <i style='color: gray;'>Al Bhukari 1/45 | Sahih Muslim 1/283</i></p>\n" +

                "<h3>LEAVING THE TOILET:</h3>\n" +
                "<p>Arabic: <b style='color: blue;'>\u063a\u064f\u0641\u0652\u0631\u064e\u0627\u0644\u064e\u0643\u064e \u0627\u0644\u0644\u0647\u064f\u0645\u064e \u0627\u0644\u062d\u064e\u0645\u0652\u062f\u064f \u0644\u0650\u0644\u0647\u0650 \u0627\u0644\u0651\u064e\u0630\u0650\u0649 \u0623\u064e\u0630\u0652\u0647\u064e\u0628\u064e \u0639\u064e\u0646\u0651\u0650 \u0627\u0644\u0623\u064e\u0630\u064e\u0649 \u0648\u064e\u0639\u064e\u0627\u0641\u064e\u0627\u0646\u0650</b></p>" +
                "<p>Translation: <b style='color: green;'>O Allah, I seek forgiveness and pardon from You. All praise be to Allah, who removed the difficulty from me and gave me ease (relief).</b></p>" +
                "<p>Reference: <i style='color: gray;'>Abu Dawood | Ibn Majah | At-Tirmidhi</i></p>\n" +
                "</body>" +
                "</html>");

        JScrollPane scrollPane = new JScrollPane(duasEditorPane);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 30)); // Adjust the button size
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> new Home().setVisible(true));
        panel.add(backButton, BorderLayout.SOUTH);

        setContentPane(panel);
        revalidate();
        repaint();
    }
    private void showAsmaEHusnaPage() {
        String[] columns = {"#", "Name", "Translation", "Meaning"};
        // Data: 99 Names of Allah
        String[][] data = {
                {"1", "الرحمن", "Ar-Rahman", "The Beneficent"},
                {"2", "الرحيم", "Ar-Raheem", "The Merciful"},
                {"3", "الملك", "Al-Malik", "The King and Owner of Dominion"},
                {"4", "القدوس", "Al-Quddus", "The Absolutely Pure"},
                {"5", "السلام", "As-Salam", "The Source of Peace and Safety"},
                {"6", "المؤمن", "Al-Mu'min", "The Guarantor"},
                {"7", "المهيمن", "Al-Muhaymin", "The Guardian, the Witness, the Overseer"},
                {"8", "العزيز", "Al-Aziz", "The All-Strong"},
                {"9", "الجبار", "Al-Jabbar", "The Compeller, the Restorer"},
                {"10", "المتكبر", "Al-Mutakabbir", "The Supreme, the Majestic"},
                {"11", "الخالق", "Al-Khaaliq", "The Creator, the Maker"},
                {"12", "البارئ", "Al-Baari", "The Evolver"},
                {"13", "المصور", "Al-Musawwir", "The Fashioner"},
                {"14", "الغفار", "Al-Ghaffaar", "The Constant Forgiver"},
                {"15", "القهار", "Al-Qahhaar", "The All-Subduer"},
                {"16", "الوهاب", "Al-Wahhaab", "The Supreme Bestower"},
                {"17", "الرزاق", "Ar-Razzaaq", "The Provider"},
                {"18", "الفتاح", "Al-Fattaah", "The Supreme Solver"},
                {"19", "العليم", "Al-'Aleem", "The All-Knowing"},
                {"20", "القابض", "Al-Qaabidh", "The Withholder"},
                {"21", "الباسط", "Al-Baasit", "The Extender"},
                {"22", "الخافض", "Al-Khaafidh", "The Reducer"},
                {"23", "الرافع", "Ar-Raafi',", "The Exalter, the Elevator"},
                {"24", "المعز", "Al-Mu'izz", "The Honourer, the Bestower"},
                {"25", "المذل", "Al-Muzil", "The Dishonourer"},
                {"26", "السميع", "As-Samee',", "The All-Hearing"},
                {"27", "البصير", "Al-Baseer", "The All-Seeing"},
                {"28", "الحكم", "Al-Hakam", "The Impartial Judge"},
                {"29", "العدل", "Al-'Adl", "The Utterly Just"},
                {"30", "اللطيف", "Al-Lateef", "The Subtle One, the Most Gentle"},
                {"31", "الخبير", "Al-Khabeer", "The All-Aware"},
                {"32", "الحليم", "Al-Haleem", "The Most Forbearing"},
                {"33", "العظيم", "Al-'Azeem", "The Magnificent, the Infinite"},
                {"34", "الغفور", "Al-Ghafoor", "The Great Forgiver"},
                {"35", "الشكور", "Ash-Shakoor", "The Most Appreciative"},
                {"36", "العلي", "Al-'Aliyy", "The Most High, the Exalted"},
                {"37", "الكبير", "Al-Kabeer", "The Most Great"},
                {"38", "الحفيظ", "Al-Hafeedh", "The Preserver"},
                {"39", "المقيت", "Al-Muqeet", "The Sustainer"},
                {"40", "الحسيب", "Al-Haseeb", "The Reckoner"},
                {"41", "الجليل", "Al-Jaleel", "The Majestic"},
                {"42", "الكريم", "Al-Kareem", "The Most Generous, the Most Esteemed"},
                {"43", "الرقيب", "Ar-Raqeeb", "The All-Watchful"},
                {"44", "المجيب", "Al-Mujeeb", "The Responsive One"},
                {"45", "الواسع", "Al-Waasi',", "The All-Encompassing, the Boundless"},
                {"46", "الحكيم", "Al-Hakeem", "The All-Wise"},
                {"47", "الودود", "Al-Wadud", "The Most Loving"},
                {"48", "المجيد", "Al-Majeed", "The Glorious, the Most Honorable"},
                {"49", "الباعث", "Al-Ba'ith", "The Infuser of New Life"},
                {"50", "الشهيد", "Ash-Shaheed", "The All-and-Ever Witnessing"},
                {"51", "الحق", "Al-Haqq", "The Absolute Truth"},
                {"52", "الوكيل", "Al-Wakeel", "The Trustee, the Disposer of Affairs"},
                {"53", "القوي", "Al-Qawiyy", "The All-Strong"},
                {"54", "المتين", "Al-Mateen", "The Firm One"},
                {"55", "الولي", "Al-Waliyy", "The Sole-Authority"},
                {"56", "الحميد", "Al-Hameed", "The Praiseworthy"},
                {"57", "المحصي", "Al-Muhsee", "The All-Enumerating, the Counter"},
                {"58", "المبدئ", "Al-Mubdi", "The Originator, the Initiator"},
                {"59", "المعيد", "Al-Mueed", "The Restorer, the Reinstater"},
                {"60", "المحيي", "Al-Muhyi", "The Giver of Life"},
                {"61", "المميت", "Al-Mumeet", "The Creator of Death"},
                {"62", "الحي", "Al-Hayy", "The Ever-Living"},
                {"63", "القيوم", "Al-Qayyum", "The Sustainer, the Self-Subsisting"},
                {"64", "الواجد", "Al-Waajid", "The Perceiver"},
                {"65", "الماجد", "Al-Maajid", "The Glorious, the Most Honorable"},
                {"66", "الواحد", "Al-Waahid", "The Only One"},
                {"67", "الاحد", "Al-Ahad", "The Sole One"},
                {"68", "الصمد", "As-Samad", "The Self-Sufficient, the Impregnable"},
                {"69", "القادر", "Al-Qaadir", "The Omnipotent"},
                {"70", "المقتدر", "Al-Muqtadir", "The Creator of All Power"},
                {"71", "المقدم", "Al-Muqaddim", "The Expediter, the Promoter"},
                {"72", "المؤخر", "Al-Mu'akhkhir", "The Delayer"},
                {"73", "الأول", "Al-Awwal", "The First (Alpha)"},
                {"74", "الأخر", "Al-Aakhir", "The Last (Omega)"},
                {"75", "الظاهر", "Az-Zaahir", "The Manifest"},
                {"76", "الباطن", "Al-Baatin", "The Hidden One, Knower of the Hidden"},
                {"77", "الوالي", "Al-Waali", "The Sole Governor"},
                {"78", "المتعال", "Al-Muta'ali", "The Self Exalted"},
                {"79", "البر", "Al-Barr", "The Source of All Goodness"},
                {"80", "التواب", "At-Tawwaab", "The Ever-Accepter of Repentance"},
                {"81", "المنتقم", "Al-Muntaqim", "The Retaliator"},
                {"82", "العفو", "Al-Afuww", "The Pardoner"},
                {"83", "الرؤوف", "Ar-Ra'oof", "The Most Kind"},
                {"84", "مالك الملك", "Maalik-ul-Mulk", "Master of the Kingdom, Owner of the Dominion"},
                {"85", "ذو الجلال والإكرام", "Dhul-Jalaali Wal-Ikraam", "Possessor of Glory and Honour, Lord of Glory and Generosity"},
                {"86", "المقسط", "Al-Muqsit", "The Just One"},
                {"87", "الجامع", "Al-Jaami',", "The Gatherer, the Uniter"},
                {"88", "الغني", "Al-Ghaniyy", "The Self-Sufficient, the Wealthy"},
                {"89", "المغني", "Al-Mughni", "The Enricher"},
                {"90", "المانع", "Al-Maani',", "The Withholder"},
                {"91", "الضار", "Ad-Daarr", "The Distresser"},
                {"92", "النافع", "An-Naafi',", "The Propitious, the Benefactor"},
                {"93", "النور", "An-Noor", "The Light"},
                {"94", "الهادي", "Al-Haadi", "The Guide"},
                {"95", "البديع", "Al-Badi", "The Incomparable Originator"},
                {"96", "الباقي", "Al-Baaqi", "The Ever-Surviving"},
                {"97", "الوارث", "Al-Waarith", "The Inheritor, the Heir"},
                {"98", "الرشيد", "Ar-Rasheed", "The Guide, Infallible Teacher, and Knower"},
                {"99", "الصبور", "As-Saboor", "The Extensively Enduring One"}
        };

        // Create Table Model
        DefaultTableModel model = new DefaultTableModel(data, columns);
        // Create Table
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(230, 230, 250)); // Lavender header background
        table.getTableHeader().setForeground(Color.BLACK);
        table.setBackground(new Color(245, 240, 255)); // Lavender rows background

        // Display Table in Scroll Pane
        JScrollPane scrollPane = new JScrollPane(table);
        // Frame Design
        JFrame frame = new JFrame("The 99 Names of Allah");
        frame.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("The 99 Names of Allah", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setBackground(new Color(230, 230, 250)); // Lavender header label background
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        frame.add(headerLabel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().setBackground(new Color(245, 240, 255)); // Lavender frame background

        frame.setSize(840, 650);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    private void showTasbihCounterPage(){
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5)); // 4 rows for added spacing
        panel.setBackground(new Color(255, 255, 204)); // Light yellow background for the entire panel

        JLabel tasbihLabel = new JLabel("Tasbih Count: 0", JLabel.CENTER);
        tasbihLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // Smaller font size
        tasbihLabel.setForeground(new Color(0,0,0)); // Black text color

        Home.TasbihCounter tasbihCounter = new Home.TasbihCounter();

        // Increment Button
        JButton incrementButton = new JButton("Increment");
        incrementButton.setPreferredSize(new Dimension(30, 20)); // Smaller button
        incrementButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font for button text
        incrementButton.setBackground(new Color(255, 182, 193)); // Baby pink background for button
        incrementButton.setForeground(Color.BLACK); // Black text

        // Reset Button
        JButton resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(30, 20)); // Smaller button
        resetButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font for button text
        resetButton.setBackground(new Color(255, 182, 193)); // Baby pink background for button
        resetButton.setForeground(Color.BLACK); // Black text

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(30, 20)); // Smaller button
        backButton.setBackground(new Color(255, 105, 180)); // Baby pink background for button
        backButton.setForeground(Color.BLACK); // White text
        backButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font for button text
        backButton.addActionListener(e -> {
            new Home().setVisible(true);
            dispose(); // Close the current window
        });

        // Action listeners for increment and reset
        incrementButton.addActionListener(e -> {
            tasbihCounter.increment();
            tasbihLabel.setText("Tasbih Count: " + tasbihCounter.getCount());
        });
        resetButton.addActionListener(e -> {
            tasbihCounter.reset();
            tasbihLabel.setText("Tasbih Count: " + tasbihCounter.getCount());
        });

        // Add components to the panel
        panel.add(tasbihLabel);
        panel.add(incrementButton);
        panel.add(resetButton);
        panel.add(backButton);

        // Adjust panel and frame size
        setContentPane(panel);
        setSize(300, 200); // Smaller window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        revalidate();
        repaint();
    }
    static class TasbihCounter {
        private int count = 0;

        public void increment() {
            count++;
        }
        public void reset() {
            count = 0;
        }
        public int getCount() {
            return count;
        }
    }
    public  static class NamazRakatChart extends JFrame {
        public  NamazRakatChart(){
            setTitle("Namaz Rakat Table");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(840, 650);
            setLocationRelativeTo(null);

            String[] columnNames = {"Prayer", "Sunnat", "Fard", "Sunnat", "Nafl", "Witr", "Nafl", "Total Rakats"};
            String[][] data = {
                    {"Fajr", "2", "2", "-", "-", "-", "-", "4"},
                    {"Zuhr", "4", "4", "2", "2", "-", "-", "12"},
                    {"Asr", "4", "4", "-", "-", "-", "-", "8"},
                    {"Maghrib", "-", "3", "2", "2", "-", "-", "7"},
                    {"Isha", "4", "4", "2", "2", "3", "2", "17"},
                    {"Jummah", "4", "2", "4+2", "2", "-", "-", "14"}
            };

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(model);
            table.setRowHeight(30);
            table.setFont(new Font("Arial", Font.PLAIN, 14));
            table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
            table.getTableHeader().setBackground(new Color(230, 230, 250)); // Lavender
            table.getTableHeader().setForeground(Color.BLACK);
            table.setBackground(new Color(240, 248, 255)); // Alice blue

            JScrollPane scrollPane = new JScrollPane(table);

            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.setBackground(new Color(224, 255, 255)); // Light cyan
            mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            mainPanel.add(scrollPane, BorderLayout.CENTER);

            JLabel headerLabel = new JLabel("Namaz Rakat Details", SwingConstants.CENTER);
            headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
            headerLabel.setOpaque(true);
            headerLabel.setBackground(new Color(230, 230, 250)); // Lavender
            headerLabel.setForeground(Color.BLACK);
            //BorderFactory: It simplifies the process of creating and applying borders, which can be used to visually separate components or add a decorative touch to them.
            headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            mainPanel.add(headerLabel, BorderLayout.NORTH);

            add(mainPanel);
            setVisible(true);
        }
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {  //Nimbus is a modern, sleek option that provides better aesthetics than the default "Metal" look.
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    //It could be used to trigger actions related to buttons.
    private JButton asmaHusnaButton;
    private JButton backButton;
    private JButton duasButton;
    private JPanel jPanel1;
    private JButton prayerTimeButton;
    private JButton rakatChartButton;
    private JButton surahButton;
    private JButton tasbihButton;
}
class TimePrayerTimes extends JFrame {
    private JLabel locationLabel;
    private JTextField locationTextField;
    private JLabel[] prayerLabels;
    private JLabel[] timeLabels;
    private boolean[] prayersPerformed;

    public TimePrayerTimes() {
        setTitle("Prayer Times");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Prayer Times");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridLayout(7, 2, 10, 10));

        locationLabel = new JLabel("Fetching location...");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel locationTitle = new JLabel("Location:");
        locationTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPanel.add(locationTitle);
        contentPanel.add(locationLabel);

        JLabel enterLocationLabel = new JLabel("Enter Location:");
        enterLocationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        locationTextField = new JTextField();
        contentPanel.add(enterLocationLabel);
        contentPanel.add(locationTextField);

        String[] prayerNames = {"Fajr", "Dhuhr", "Asr", "Maghrib", "Isha"};
        prayerLabels = new JLabel[5];
        timeLabels = new JLabel[5];
        prayersPerformed = new boolean[5];

        for (int i = 0; i < prayerNames.length; i++) {
            prayerLabels[i] = new JLabel(prayerNames[i]);
            prayerLabels[i].setFont(new Font("Arial", Font.BOLD, 16));
            timeLabels[i] = new JLabel("Loading...");
            timeLabels[i].setFont(new Font("Arial", Font.PLAIN, 16));

            contentPanel.add(prayerLabels[i]);
            contentPanel.add(timeLabels[i]);
        }
        contentPanel.setBackground(new Color(255, 219, 219)); // baby pink background
        add(contentPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton refreshButton = new JButton("Refresh Times");
        refreshButton.setBackground(new Color(250,250,250));
        refreshButton.addActionListener(e -> updatePrayerTimes());
        buttonPanel.add(refreshButton);

        JButton markButton = new JButton("Mark as Performed");
        markButton.setBackground(new Color(250,250,250));
        markButton.addActionListener(e -> showMarkAsPerformedFrame());
        buttonPanel.add(markButton);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(250,250,250));
        backButton.addActionListener(e -> dispose());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void updatePrayerTimes() {
        new Thread(() -> {  //To run multiple task co-currently
            try {      // any error can be handled properly.
                String locationInput = locationTextField.getText().trim();//removes any trailing and leading spaces.
                if (locationInput.isEmpty()) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this,
                            "Please enter a location.", "Error", JOptionPane.ERROR_MESSAGE));
                    return;
                }
                //URL ask the open cage API to search for the location
                String geocodingUrl = "https://api.opencagedata.com/geocode/v1/json?q=" + locationInput + "&key=5ab7c9553497471f8bc374ab2a0ff6f7";
                //Line SENDS THE  URL To the API and get data back.
                String geocodingResponse = getHttpResponse(geocodingUrl);
                //Maintain Jsonformat
                JSONObject geocodingJson = new JSONObject(geocodingResponse);
                //we  can check result empty location not found.
                if (geocodingJson.getJSONArray("results").length() == 0) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this,
                            "Location not found. Please try again.", "Error", JOptionPane.ERROR_MESSAGE));
                    return;
                }
                double latitude = geocodingJson.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getDouble("lat");
                double longitude = geocodingJson.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getDouble("lng");
                SwingUtilities.invokeLater(() -> locationLabel.setText(locationInput));
                String prayerTimesUrl = String.format(
                        "https://api.aladhan.com/v1/timings?latitude=%s&longitude=%s&method=2",
                        latitude, longitude);
                String prayerTimesResponse = getHttpResponse(prayerTimesUrl);
                JSONObject prayerJson = new JSONObject(prayerTimesResponse);
                JSONObject timings = prayerJson.getJSONObject("data").getJSONObject("timings");
                String[] prayers = {"Fajr", "Dhuhr", "Asr", "Maghrib", "Isha"};
                SwingUtilities.invokeLater(() -> {
                    for (int i = 0; i < prayers.length; i++) {
                        timeLabels[i].setText(timings.getString(prayers[i]));
                        prayersPerformed[i] = false; // Reset performed status
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();    // This print message
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this,
                        "Failed to update prayer times. Please check your internet connection.",
                        "Error", JOptionPane.ERROR_MESSAGE));
            }
        }).start();
    }
    private void showMarkAsPerformedFrame() {
        JFrame markFrame = new JFrame("Mark Prayers as Performed");
        markFrame.setSize(850, 650);
        markFrame.setLocationRelativeTo(this);
        markFrame.setLayout(new GridLayout(6, 1, 10, 10));
        markFrame.getContentPane().setBackground(new Color(255 , 182 ,193));

        JCheckBox[] prayerCheckBoxes = new JCheckBox[5];
        for (int i = 0; i < prayerLabels.length; i++) {
            int index = i; // Capture index for lambda
            prayerCheckBoxes[i] = new JCheckBox(prayerLabels[i].getText());
            prayerCheckBoxes[i].setFont(new Font("Arial", Font.BOLD, 25));
            prayerCheckBoxes[i].setSelected(prayersPerformed[i]);
            prayerCheckBoxes[i].addActionListener(e -> prayersPerformed[index] = prayerCheckBoxes[index].isSelected());
            markFrame.add(prayerCheckBoxes[i]);
        }

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(255,182,193));
        saveButton.setForeground(new Color(0,0,0));
        saveButton.setPreferredSize(new Dimension(30, 30));
        saveButton.addActionListener(e -> markFrame.dispose());
        saveButton.setPreferredSize(new Dimension(10, 10));
        markFrame.add(saveButton);
        markFrame.setVisible(true);
    }
    private String getHttpResponse(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        return content.toString();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimePrayerTimes::new);
    }
}
