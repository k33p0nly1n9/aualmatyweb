/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;
import javax.servlet.http.*;

/**
 *
 * @author bayan
 */
public class DbHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "1q2w3e4r";

    public static final String TABLE_PERSON = "persons";
    public static final String TABLE_ORDERS = "orders";
    public static final String TABLE_ORDERNPERSON = "ordernperson";
    public static final String TABLE_EXECUTOR = "executor";
    // public static final String TABLE_EXECUTORS = "executors";
    public static final String TABLE_SERVICE = "service";
    //  public static final String TABLE_SERVICES = "services";
    // public static final String TABLE_SECTION = "section";
    public static final String TABLE_SECTIONS = "sections";
    public static final String TABLE_BOOKMARKS = "bookmarks";
    public static final String TABLE_REVIEWS = "reviews";
    public static final String TABLE_EXECUTORNSERVICES = "executornservices";
    public static final String TABLE_NOTIFY = "notify";
    public static final String TABLE_EXECUTORNPERSON = "executor_person";
    public static final String TABLE_RESPONSES = "responses";
    public static final String TABLE_ANSWERS = "answers";
    public static final String TABLE_REVIEWNANSWERS = "reviewnanswers";

    public static final String KEY_PERSON_ID = "person_id";
    public static final String KEY_ORDER_ID = "order_id";
    public static final String KEY_EXECUTOR_ID = "executor_id";
    public static final String KEY_SERVICE_ID = "service_id";
    public static final String KEY_SECTION_ID = "section_id";
    public static final String KEY_EXECUTORNSERVICES_ID = "executnservice_id";
    public static final String KEY_NOTIFY_ID = "notify_id";
    public static final String KEY_ORDERNPERSON_PART_ID = "ordernperson_id";
    public static final String KEY_EXECUTORNPERSON_ID = "executnperson_id";
    public static final String KEY_RESPONSES_ID = "responses_id";
    public static final String KEY_REVIEWNANSWERS_ID = "reviewnanswers_id";

    public static final String KEY_PERSON_NAME = "person_name";
    public static final String KEY_PERSON_LASTNAME = "person_lastname";
    public static final String KEY_PERSON_PASSWD = "person_passw";
    public static final String KEY_PERSON_CREATED_DATE = "person_created_date";
    public static final String KEY_PERSON_NUMBER = "person_number";
    public static final String KEY_PERSON_PHOTO = "person_photo";
    public static final String KEY_PERSON_RATING = "person_rating";
    public static final String KEY_PERSON_BIRTHDAY = "person_birthday";
    public static final String KEY_PERSON_ISEXECUTOR = "isExecutor";

    public static final String KEY_ORDER_TITLE = "order_title";
    public static final String KEY_ORDER_SECTION_ID = "order_section_id";
    public static final String KEY_ORDER_PRICE = "order_price";
    public static final String KEY_ORDER_CREATED_DATE = "order_created_date";
    public static final String KEY_ORDER_DEADLINE = "order_deadline";
    public static final String KEY_ORDER_DESCRIPTION = "order_description";
    public static final String KEY_ORDER_ISANONNOTE = "order_isanonymnote";
    public static final String KEY_ORDER_CUSTOMER_ID = "customer_id";

    public static final String KEY_EXECUTOR_PERSON_ID = "executor_personId";
    public static final String KEY_EXECUTOR_SECTION_ID = "executor_sectionId";
    public static final String KEY_EXECUTOR_SPECIALIZATION = "executor_specialization";
    public static final String KEY_EXECUTOR_DESCRIPTION = "executor_description";
    public static final String KEY_EXECUTOR_COVERPHOTO = "executor_coverphoto";

    // public static final String KEY_SERVICE_PERSON_ID = "person_id";
    public static final String KEY_SERVICE_TITLE = "service_title";
    public static final String KEY_SERVICE_PRICE = "service_price";

    public static final String KEY_SECTION_TITLE = "section_title";

    public static final String KEY_BOOKMARK_PART_ID = "bookm_id";
    public static final String KEY_BOOKMARK_PERSON_ID = "bookm_person_id";
    public static final String KEY_BOOKMARK_EXECUTOR_ID = "bookm_executor_id";
    public static final String KEY_BOOKMARK_ORDER_ID = "bookm_order_id";

    public static final String KEY_ORDERNPERSON_CUSTOMER_ID = "ordernpers_customer_id";
    public static final String KEY_ORDERNPERSON_ORDER_ID = "ordernpers_order_id";
    public static final String KEY_ORDERNPERSON_EXECUTOR_ID = "ordernpers_executor_id";
    public static final String KEY_ORDERNPERSON_STATUS = "ordernpers_status";

    public static final String KEY_REVIEW_PART_ID = "review_id";
    public static final String KEY_REVIEW_EXECUTOR_ID = "review_executor_id";
    public static final String KEY_REVIEW_CUSTOMER_ID = "review_customer_id";
    public static final String KEY_REVIEW_REVIEW_TEXT = "review_text";
    public static final String KEY_REVIEW_ASSESSMENT = "review_assessment";
    public static final String KEY_REVIEW_CREATED_DATE = "review_created_date";

    public static final String KEY_ANSWER_PART_ID = "answer_id";
    public static final String KEY_ANSWER_REVIEW_ID = "answer_reviewid";
    public static final String KEY_ANSWER_WHOANSWERS_ID = "answer_whoanswers";
    public static final String KEY_ANSWER_WHOPOSTED_ID = "answer_whoposted";
    public static final String KEY_ANSWER_TEXT = "answer_text";
    public static final String KEY_ANSWER_CREATED_DATE = "answer_created_date";

    public static final String KEY_EXECUTORNSERVICES_EXECUTOR_ID = "executorId";
    public static final String KEY_EXECUTORNSERVICES_SERVICE_ID = "serviceId";

    public static final String KEY_REVIEWNANSWERS_REVIEW_ID = "reviewnanswers_reviewid";
    public static final String KEY_REVIEWNANSWERS_ANSWER_ID = "reviewnanswers_answerid";

    public static final String KEY_NOTIFY_TEXT = "notify_text";
    public static final String KEY_NOTIFY_PERSONID = "notify_personid";
    public static final String KEY_NOTIFY_CREATED_DATE = "notify_createddt";
    public static final String KEY_NOTIFY_SECTION_ID = "notify_sectionId";
    public static final String KEY_NOTIFY_SRC_ID = "notify_src";
    public static final String KEY_NOTIFY_STATUS_ID = "notify_status";

    public static final String KEY_EXECUTORNPERSON_EXECUTOR_ID = "executorId";
    public static final String KEY_EXECUTORNPERSON_PERSON_ID = "personId";

    public static final String KEY_RESPONSES_PERSON_ID = "response_personid";
    public static final String KEY_RESPONSES_ORDER_ID = "response_orderid";
    public static final String KEY_RESPONSES_TEXT = "response_text";
    public static final String KEY_RESPONSES_SUGGESTEDPRICE = "response_suggestesprice";
    public static final String KEY_RESPONSES_CREATEDDATE = "response_date";

    // <editor-fold defaultstate="collapsed" desc="quiziz">
    public ArrayList<Question> getAllQuestions() {
        String query = "select * from questions";
        ArrayList<Question> result = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("idQuestn");
                String title = rs.getString("title");
                String ans1 = rs.getString("opt1");
                String ans2 = rs.getString("opt2");
                String ans3 = rs.getString("opt3");
                String ans4 = rs.getString("opt4");
                int correct = rs.getInt("correct");
                Question t = new Question(title, ans1, ans2, ans3, ans4, correct);
                t.setId(id);
                result.add(t);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public void addQuestion(Question question) {
        String query = "INSERT INTO questions "
                       + "(title, opt1,opt2,opt3,opt4,correct)"
                       + " VALUES(?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            con.setAutoCommit(false);
            PreparedStatement pstmt
                              = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, question.getTitle());
            pstmt.setString(2, question.getOpt1());
            pstmt.setString(3, question.getOpt2());
            pstmt.setString(4, question.getOpt3());
            pstmt.setString(5, question.getOpt4());
            pstmt.setInt(6, question.getCorrect());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            int qId = 0;
            if (rs.next()) {
                qId = rs.getInt(1);
                question.setId(qId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Person">
    public void addPerson(Person person) {
        String query = "INSERT INTO " + TABLE_PERSON + "(" + KEY_PERSON_NAME + ", " + KEY_PERSON_LASTNAME + ", " + KEY_PERSON_NUMBER
                       + ", " + KEY_PERSON_PASSWD + ", " + KEY_PERSON_RATING + ", " + KEY_PERSON_CREATED_DATE + ", " + KEY_PERSON_PHOTO + ", " + KEY_PERSON_BIRTHDAY
                       + ") VALUES (?,?,?,?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            con.setAutoCommit(false);
            PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getLastname());
            pstmt.setString(3, person.getNumber());
            pstmt.setString(4, person.getPasswd());
            pstmt.setDouble(5, person.getRating());
            pstmt.setLong(6, person.getCreatedDate());
            pstmt.setString(7, person.getPhoto());
            pstmt.setLong(8, person.getBirthday());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.first()) {
                person.setId(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Person getPerson(int personId) {

        String query = "select * from " + TABLE_PERSON
                       + " where " + KEY_PERSON_ID + "=" + personId;

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt2 = con.createStatement();
            ResultSet res = stmt2.executeQuery(query);

            if (res.next()) {
                Person p = this.getPersonRs(res);
                return p;
            }

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return null;
    }

    public ArrayList<Person> getPersons() {
        String query = "select * from "
                       + TABLE_PERSON + " order by " + KEY_PERSON_ID
                       + " desc";

        ArrayList<Person> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Person person = this.getPersonRs(rs);
                result.add(person);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    private Person getPersonRs(ResultSet rs) throws Exception {
        int id = rs.getInt(KEY_PERSON_ID);
        String name = rs.getString(KEY_PERSON_NAME);
        String last = rs.getString(KEY_PERSON_LASTNAME);
        String number = rs.getString(KEY_PERSON_NUMBER);
        String passwd = rs.getString(KEY_PERSON_PASSWD);
        int rating = rs.getInt(KEY_PERSON_RATING);
        long date = rs.getLong(KEY_PERSON_CREATED_DATE);
        String photo = rs.getString(KEY_PERSON_PHOTO);

        Person p = new Person(id, name, last, passwd, number, rating, date);
        p.setPhoto(photo);
        return p;
    }

    /**
     * Возвращает пользователя по номеру, чтобы проверить зарегистрирован ли он
     * уже
     */
    public Person getPersonByNumb(String number) {
        String query = "select * from "
                       + TABLE_PERSON + " where " + KEY_PERSON_NUMBER + "='"
                       + number + "'";

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                Person p = getPersonRs(rs);
                return p;
            }

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return null;
    }

    /**
     * Возвращает пользователя по номеру и паролю для авторизации
     */
    public Person getPersonByPasswdNNumb(String numb, String passwd) {
        String query = "select * from " + TABLE_PERSON + " where " + KEY_PERSON_NUMBER + "='"
                       + numb + "' AND " + KEY_PERSON_PASSWD + "= '" + passwd + "'";

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                Person p = getPersonRs(rs);
                return p;
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return null;
    }

    public ArrayList<Integer> getPersonsId() {
        String query = "SELECT " + KEY_PERSON_ID + " FROM " + TABLE_PERSON + " order by " + KEY_PERSON_ID
                       + " desc";

        ArrayList<Integer> arrID = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                arrID.add(rs.getInt(KEY_PERSON_ID));
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return arrID;
    }

    public boolean getPersonIsExecutorField(int personId) {
        Boolean b = false;
        String query = "SELECT " + KEY_PERSON_ISEXECUTOR + " FROM " + TABLE_PERSON
                       + " WHERE " + KEY_PERSON_ID + "=" + personId;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.first()) {
                int v = rs.getInt(KEY_PERSON_ID);
                if (v == 1) {
                    b = true;
                }
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return b;
    }

    public int getPersonRatingById(int id) {
        String query = "select (select sum(" + KEY_REVIEW_ASSESSMENT + ") from " + TABLE_REVIEWS + " where " + KEY_REVIEW_EXECUTOR_ID
                       + " = " + id + ")/(select count(" + KEY_REVIEW_CUSTOMER_ID + ") from " + TABLE_REVIEWS + " where " + KEY_REVIEW_EXECUTOR_ID
                       + " = " + id + ")";
        int rating = -1;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.first()) {
                rating = rs.getInt(1);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return rating;
    }

    public void updatePerson(Person person) {
        String query = "UPDATE " + TABLE_PERSON + " SET "
                       + KEY_PERSON_NAME + "=?,"
                       + KEY_PERSON_LASTNAME + "=?,"
                       + KEY_PERSON_PASSWD + "=?,"
                       + KEY_PERSON_RATING + "=?,"
                       + KEY_PERSON_NUMBER + "=?,"
                       + KEY_PERSON_PHOTO + "=?"
                       + " WHERE " + KEY_PERSON_ID + "=" + person.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            con.setAutoCommit(false);
            PreparedStatement pstmt = con.prepareStatement(query, Statement.NO_GENERATED_KEYS);

            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getLastname());
            pstmt.setString(3, person.getPasswd());
            pstmt.setInt(4, person.getRating());
            pstmt.setString(5, person.getNumber());
            pstmt.setString(6, person.getPhoto());

            pstmt.executeUpdate();

            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updatePersonRatingById(int personId) {
        int rating = getPersonRatingById(personId);

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            String query = "UPDATE " + TABLE_PERSON + " SET "
                           + KEY_PERSON_RATING + "= " + rating
                           + " WHERE " + KEY_PERSON_ID + "= " + personId;

            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setPersonIsExecutorField(int personId, Boolean b) {
        int value;
        if (b == true) {
            value = 1;
        }
        else {
            value = 0;
        }
        String query = "UPDATE " + TABLE_PERSON + " SET "
                       + KEY_PERSON_ISEXECUTOR + "= " + value
                       + " WHERE " + KEY_PERSON_ID + "= " + personId;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deletePerson(int personId) {
        String query = "DELETE * FROM " + TABLE_PERSON + " WHERE "
                       + KEY_PERSON_ID + "=" + personId;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean deletePersonPhoto(int personId) {
        boolean b = false;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            String query = "select " + KEY_PERSON_PHOTO + " from " + TABLE_PERSON + " where " + KEY_PERSON_ID + "=" + personId;
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            String photo = null;
            if (rs.first()) {
                photo = rs.getString(1);
            }
            String path = "C:\\Users\\bayan\\OneDrive\\Документы\\NetBeansProjects\\Test\\web\\Content";

            java.io.File file = new java.io.File(path + java.io.File.separator + photo);
            b = file.delete();

            String query2 = "update " + TABLE_PERSON + " set " + KEY_PERSON_PHOTO +  
                            " = 'executors_default_image.png' " + " where " + KEY_PERSON_ID + "=" + personId;
            stmt.execute(query2);

            return b;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Executor">
    public void addExecutor(Executor executor) {
        String query = "INSERT INTO " + TABLE_EXECUTOR + "(" + KEY_EXECUTOR_PERSON_ID
                       + ", " + KEY_EXECUTOR_SECTION_ID + ", " + KEY_EXECUTOR_SPECIALIZATION
                       + ", " + KEY_EXECUTOR_DESCRIPTION + ") VALUES (?,?,?,?)";

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            con.setAutoCommit(false);
            PreparedStatement pstmt
                              = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, executor.getPersonId());
            pstmt.setInt(2, executor.getSectionId());
            pstmt.setString(3, executor.getSpecialztn());
            pstmt.setString(4, executor.getDescriptn());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
                executor.setId(id);
            }
            con.commit();

            onExecutorCreate(executor);
            createExecutorServices(executor);
            onExecutorServicesCreate(executor);
            setPersonIsExecutorField(executor.getPersonId(), true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Executor getExecutorFromRS(ResultSet set) throws Exception {

        int id = set.getInt(KEY_EXECUTOR_ID);
        int personId = set.getInt(KEY_EXECUTOR_PERSON_ID);
        int sectionId = set.getInt(KEY_EXECUTOR_SECTION_ID);
        String spcltn = set.getString(KEY_EXECUTOR_SPECIALIZATION);
        String dscrp = set.getString(KEY_EXECUTOR_DESCRIPTION);

        Executor executor = new Executor(id, personId, sectionId, spcltn, dscrp);
        return executor;
    }

    public Executor getExecutor(int executorId) {
        String query = "select * from " + TABLE_EXECUTOR + " where "
                       + KEY_EXECUTOR_ID + "=" + executorId;

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                Executor executor = this.getExecutorFromRS(rs);
                return executor;
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return null;
    }

    public ArrayList<Executor> getAllExecutors() {
        String query = "select * from "
                       + TABLE_EXECUTOR + " order by " + KEY_EXECUTOR_ID
                       + " desc";

        ArrayList<Executor> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER,
                                                          DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Executor executor = this.getExecutorFromRS(rs);
                result.add(executor);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public ArrayList<Executor> getExecutorsBySectionId(int cId) {
        String query = "select * from "
                       + TABLE_EXECUTOR + " where " + KEY_EXECUTOR_SECTION_ID + " = " + cId + " order by " + KEY_EXECUTOR_ID
                       + " desc";

        ArrayList<Executor> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER,
                                                          DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Executor executor = this.getExecutorFromRS(rs);
                result.add(executor);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public int getExecutorsCount() {
        String query = "select count(*) from " + TABLE_EXECUTOR;
        int count = 0;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return count;
    }

    public ArrayList<Executor> getExecutorsRecords(int start, int total) {
        ArrayList<Executor> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            int i = total * (start - 1);
            PreparedStatement ps = con.prepareStatement("SELECT * from " + TABLE_EXECUTOR + " limit "
                                                        + i + "," + total);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Executor executor = getExecutorFromRS(rs);
                list.add(executor);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return list;
    }

    public ArrayList<Service> getExecutorServices(int executorId) {
        String query = "SELECT " + TABLE_SERVICE + "." + KEY_SERVICE_ID + ", "
                       + TABLE_SERVICE + "." + KEY_SERVICE_TITLE + ", "
                       + TABLE_SERVICE + "." + KEY_SERVICE_PRICE + " FROM " + TABLE_SERVICE
                       + " JOIN " + TABLE_EXECUTORNSERVICES + " ON " + TABLE_SERVICE + "."
                       + KEY_SERVICE_ID + "=" + TABLE_EXECUTORNSERVICES + "."
                       + KEY_EXECUTORNSERVICES_SERVICE_ID + " WHERE " + TABLE_EXECUTORNSERVICES
                       + "." + KEY_EXECUTORNSERVICES_EXECUTOR_ID + "=" + executorId;

        ArrayList<Service> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER,
                                                          DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Service service = this.getServiceFromRS(rs);
                result.add(service);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getExecutorsServicesId(int executorId) {
        String query = "select " + KEY_EXECUTORNSERVICES_SERVICE_ID + " FROM "
                       + TABLE_EXECUTORNSERVICES + " where " + KEY_EXECUTORNSERVICES_EXECUTOR_ID + " = " + executorId;
        ArrayList<Integer> arrID = new ArrayList();
        try (Connection con = DriverManager.getConnection(URL, DBUSER,
                                                          DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                arrID.add(rs.getInt(1));
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return arrID;
    }

    public void updateExecutor(Executor executor) {
        String query = "UPDATE " + TABLE_EXECUTOR + " SET "
                       + KEY_EXECUTOR_SPECIALIZATION + "='" + executor.getSpecialztn() + "', "
                       + KEY_EXECUTOR_DESCRIPTION + "=' " + executor.getDescriptn() + "', "
                       + KEY_EXECUTOR_PERSON_ID + "= " + executor.getPersonId() + ", "
                       + KEY_EXECUTOR_SECTION_ID + "= " + executor.getSectionId()
                       + " WHERE " + KEY_EXECUTOR_ID + "=" + executor.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);

            updateExecutorServices(executor);
            updateExecutorServices(executor);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteExecutor(int executorId) {
        String query = "DELETE * FROM " + TABLE_EXECUTOR + " WHERE "
                       + KEY_EXECUTOR_ID + "=" + executorId;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            int personId = getPersonIdByExecutorId(executorId);
            setPersonIsExecutorField(personId, false);
            onExecutorDelete(executorId);

            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //</editor-fold>

    // <editor-fold desc="Order" defaultstate="collapsed">
    public void addOrder(Order order) {
        String query = "INSERT INTO " + TABLE_ORDERS + "(" + KEY_ORDER_CUSTOMER_ID + ", " + KEY_ORDER_TITLE
                       + ", " + KEY_ORDER_SECTION_ID + ", " + KEY_ORDER_PRICE + ", "
                       + KEY_ORDER_DESCRIPTION + ", " + KEY_ORDER_DEADLINE + ", "
                       + KEY_ORDER_CREATED_DATE + ", " + KEY_ORDER_ISANONNOTE + ") VALUES (?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            con.setAutoCommit(false);
            PreparedStatement pstmt
                              = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, order.getCustomerId());
            pstmt.setString(2, order.getTitle());
            pstmt.setInt(3, order.getSectionId());
            pstmt.setDouble(4, order.getPrice());
            pstmt.setString(5, order.getDescription());
            pstmt.setLong(6, order.getDeadline());
            pstmt.setLong(7, DataUtils.getCurentDateInLong());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
                order.setId(id);
            }
            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Order getOrderFromRS(ResultSet set) throws Exception {

        int id = set.getInt(KEY_ORDER_ID);
        String title = set.getString(KEY_ORDER_TITLE);
        int customerId = set.getInt(KEY_ORDER_CUSTOMER_ID);
        int sectionId = set.getInt(KEY_ORDER_SECTION_ID);
        double price = set.getDouble(KEY_ORDER_PRICE);
        String dscrp = set.getString(KEY_ORDER_DESCRIPTION);
        Long deadline = set.getLong(KEY_ORDER_DEADLINE);
        Long createdDate
             = set.getLong(KEY_ORDER_CREATED_DATE);

        Order order = new Order(id, title, sectionId, price, dscrp, deadline, createdDate);
        order.setCustomerId(customerId);
        return order;
    }

    public Order getOrder(int orderId) {
        String query = "select * from "
                       + TABLE_ORDERS + " where " + KEY_ORDER_ID + "=" + orderId;

        Order order = new Order();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                order = this.getOrderFromRS(rs);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return order;
    }

    public ArrayList<Order> getOrders() {
        String query = "select * from "
                       + TABLE_ORDERS + " order by " + KEY_ORDER_ID
                       + " desc";

        ArrayList<Order> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Order order = getOrderFromRS(rs);
                result.add(order);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public ArrayList<Order> getPersonOrdersById(int personId) {
        String query = "select * from "
                       + TABLE_ORDERS + " where " + KEY_ORDER_CUSTOMER_ID + "= " + personId + " order by " + KEY_ORDER_CREATED_DATE
                       + " desc";
        ArrayList<Order> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Order order = getOrderFromRS(rs);
                result.add(order);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public ArrayList<Order> getOrdersRecords(int start, int total) {
        ArrayList<Order> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            int i = total * (start - 1);
            PreparedStatement ps = con.prepareStatement("SELECT * from " + TABLE_ORDERS + " limit "
                                                        + i + "," + total);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = getOrderFromRS(rs);
                list.add(order);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return list;
    }

    public int getOrderCount() {
        String query = "select count(*) from " + TABLE_ORDERS;
        int count = 0;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                count = rs.getInt(1);

            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return count;
    }

    public ArrayList<Order> getOrders(Order_search search) {
        if (search == null) {
            search = new Order_search();
        }

        ArrayList<Order> result = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_ORDERS + " WHERE 1=1";
        if (search.getPersonId() != 0) {
            sql += " AND (" + KEY_ORDERNPERSON_CUSTOMER_ID + "=" + search.getPersonId()
                   + " OR " + KEY_ORDERNPERSON_EXECUTOR_ID + "=" + search.getPersonId() + ")";
        }
        else if (search.getPersonId1ThatISend() != 0) {
            sql += " AND " + KEY_ORDERNPERSON_CUSTOMER_ID + "=" + search.getPersonId1ThatISend();
        }
        else if (search.getPersonId2ThatIAccept() != 0) {
            sql += " AND " + KEY_ORDERNPERSON_EXECUTOR_ID + "=" + search.getPersonId2ThatIAccept();
        }
        if (search.getStatuses().isEmpty()) {
            String statuses = "";
            for (String s : search.getStatuses()) {
                statuses += "'" + s + "', ";
            }
            if (statuses.endsWith(", ")) {
                statuses = statuses.substring(0, statuses.length() - 2);
            }
            sql += " AND " + KEY_ORDERNPERSON_STATUS + " IN(" + statuses + ")";
        }
        sql += " ORDER BY " + KEY_ORDERNPERSON_PART_ID + " DESC";

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Order order = getOrderFromRS(rs);
                result.add(order);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public void updateOrder(Order order) {
        String query = "UPDATE " + TABLE_ORDERS + " SET "
                       + KEY_ORDER_TITLE + "='" + order.getTitle() + "', "
                       + KEY_ORDER_SECTION_ID + "=' " + order.getSectionId() + "', "
                       + KEY_ORDER_PRICE + "= " + order.getPrice() + ", "
                       + KEY_ORDER_DESCRIPTION + "= '" + order.getDescription() + "', "
                       + KEY_ORDER_DEADLINE + "= " + order.getDeadline()
                       + " WHERE " + KEY_ORDER_ID + " = " + order.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteOrder(int orderId) {
        String query = "DELETE * FROM " + TABLE_ORDERS + " WHERE "
                       + KEY_ORDER_ID + "=" + orderId;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // </editor-fold>

    //<editor-fold desc="Service">
    public void addService(Service service) {
        String query = "INSERT INTO " + TABLE_SERVICE + "(" + KEY_SERVICE_TITLE + ", "
                       + KEY_SERVICE_PRICE + ") VALUES ( ?,?)";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            con.setAutoCommit(false);
            PreparedStatement pstmt
                              = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, service.getTitle());
            pstmt.setDouble(2, service.getPrice());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
                service.setId(id);
            }
            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Service getService(int serviceId) {

        String query = "select * from "
                       + TABLE_SERVICE + " where " + KEY_SERVICE_ID + " = " + serviceId;
        Service s = new Service();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                s = this.getServiceFromRS(rs);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return s;
    }

    public void createExecutorServices(Executor executor) {
        if (executor.getServices() == null || executor.getId() == 0) {
            return;
        }
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            for (Service service : executor.getServices()) {
                String sql = "INSERT INTO " + TABLE_SERVICE + "("
                             + KEY_SERVICE_PRICE + ", " + KEY_SERVICE_TITLE
                             + ") VALUES (" + service.getPrice() + ", '" + service.getTitle() + "')";

                Statement stmt = con.createStatement();
                stmt.execute(sql);

                String sqlMaxId = "SELECT MAX(" + KEY_SERVICE_ID + ") FROM "
                                  + TABLE_SERVICE;
                int maxId = 0;
                ResultSet rs = stmt.executeQuery(sqlMaxId);
                if (rs.first()) {
                    maxId = rs.getInt(1);
                }
                service.setId(maxId);

            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void loadExecutorServices(Executor executor) {

        String sql = "SELECT " + TABLE_SERVICE + "." + KEY_SERVICE_ID + ", "
                     + TABLE_SERVICE + "." + KEY_SERVICE_TITLE + ", " + TABLE_SERVICE + "." + KEY_SERVICE_PRICE
                     + " FROM "
                     + TABLE_SERVICE + " JOIN " + TABLE_EXECUTORNSERVICES + " ON "
                     + TABLE_SERVICE + "." + KEY_SERVICE_ID + "=" + TABLE_EXECUTORNSERVICES
                     + "." + KEY_EXECUTORNSERVICES_SERVICE_ID + " WHERE " + TABLE_EXECUTORNSERVICES
                     + "." + KEY_EXECUTORNSERVICES_EXECUTOR_ID + "=" + executor.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

//SELECT distinct Service.ed, service.title, service.price from service
/*join executernservices
on service._id = executernservices.serviceid
where executernservices.executorid = executorid
             */
            if (executor.getServices() != null && !(executor.getServices().isEmpty())) {
                executor.getServices().clear();
            }
            while (rs.next()) {
// String serviceTitle = c2.getString(1);
// int serviceId = c2.getInt(2);
// Service service = new Service();
// service.setId(serviceId);
//service.setTitle(serviceTitle);
                Service service = new Service(rs.getInt(KEY_SERVICE_ID), rs.getString(KEY_SERVICE_TITLE), rs.getDouble(KEY_SERVICE_PRICE));
                executor.getServices().add(service);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

    }

    public void updateService(Service service) {
        String query = "UPDATE " + TABLE_SERVICE + " SET "
                       + KEY_SERVICE_TITLE + "='" + service.getTitle() + "', "
                       + KEY_SERVICE_PRICE + "=" + service.getPrice()
                       + " WHERE " + KEY_SERVICE_ID + " = " + service.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteExecutorServices(int executorId) {
        if (executorId == 0) {
            return;
        }
        String query = "DELETE FROM " + TABLE_SERVICE + " WHERE " + KEY_SERVICE_ID + " IN ( SELECT " + KEY_SERVICE_ID + " FROM "
                       + TABLE_EXECUTORNSERVICES + " WHERE " + KEY_EXECUTORNSERVICES_EXECUTOR_ID + " = " + executorId + ")";

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteService(int serviceId) {
        String query = "DELETE * FROM " + TABLE_SERVICE + " WHERE "
                       + KEY_SERVICE_ID + "=" + serviceId;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Service getServiceFromRS(ResultSet rs) throws Exception {
        int id = rs.getInt(KEY_SERVICE_ID);
        String title = rs.getString(KEY_SERVICE_TITLE);
        double price = rs.getDouble(KEY_SERVICE_PRICE);
        Service service = new Service(id, title, price);
        return service;
    }

//</editor-fold>
//<editor-fold desc="EXECUTORNSERVICES">
    public void onExecutorServicesCreate(Executor executor) {
        if (executor.getServices() == null || executor.getId() == 0) {
            return;
        }
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            for (Service service : executor.getServices()) {
                String query = "INSERT INTO " + TABLE_EXECUTORNSERVICES + "(" + KEY_EXECUTORNSERVICES_EXECUTOR_ID + ", "
                               + KEY_EXECUTORNSERVICES_SERVICE_ID + ") VALUES ( " + executor.getId() + "," + service.getId() + " )";
                Statement stmt = con.createStatement();
                stmt.execute(query);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateExecutorNServices(Executor executor) {
        if (executor.getServices() == null || executor.getId() == 0) {
            return;
        }
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            deleteFromExecutorNServicesByExecutorId(executor.getId());

            Statement stmt = con.createStatement();

            for (Service service : executor.getServices()) {
                String sql = "INSERT INTO " + TABLE_EXECUTORNSERVICES + "("
                             + KEY_EXECUTORNSERVICES_EXECUTOR_ID + ", " + KEY_EXECUTORNSERVICES_SERVICE_ID
                             + ") VALUES (" + executor.getId() + ", " + service.getId() + ")";

                stmt.execute(sql);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteFromExecutorNServicesByExecutorId(int id) {
        String sql = "DELETE FROM " + TABLE_EXECUTORNSERVICES + " WHERE " + KEY_EXECUTORNSERVICES_EXECUTOR_ID + " = " + id;

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateExecutorServices(Executor executor) {
        if (executor.getServices() == null || executor.getId() == 0) {
            return;
        }

        String sql = "DELETE FROM " + TABLE_EXECUTORNSERVICES
                     + " WHERE " + KEY_EXECUTORNSERVICES_EXECUTOR_ID + "=" + executor.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(sql);

//SELECT distinct Service.ed, service.title, service.price from service
/*join executernservices
on service._id = executernservices.serviceid
where executernservices.executorid = executorid
             */
            deleteExecutorServices(executor.getId());
            for (Service service : executor.getServices()) {
                sql = "INSERT INTO " + TABLE_EXECUTORNSERVICES + "("
                      + KEY_EXECUTORNSERVICES_EXECUTOR_ID + ", " + KEY_EXECUTORNSERVICES_SERVICE_ID
                      + ") VALUES (" + executor.getId() + ", " + service.getId() + ")";
                stmt.execute(sql);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
    }

//</editor-fold>
    //<editor-fold desc="Section">
    public void addSection(Section section) {
        String query = "INSERT INTO " + TABLE_SECTIONS + "(" + KEY_SECTION_TITLE + ") VALUES ( '"
                       + section.getTitle() + ")";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Section getSection(int sectionId) {

        String query = "select * from "
                       + TABLE_SECTIONS + " where " + KEY_SECTION_ID + "=" + sectionId;

        Section n = new Section();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                int id = rs.getInt(KEY_SECTION_ID);
                String title = rs.getString(KEY_SECTION_TITLE);
                n.setId(id);
                n.setTitle(title);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return n;
    }

    public ArrayList<Section> getSections() {
        String query = "select * from "
                       + TABLE_SECTIONS + " order by " + KEY_SECTION_ID + " desc";

        ArrayList<Section> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(KEY_SECTION_ID);
                String title = rs.getString(KEY_SECTION_TITLE);
                Section section = new Section(id, title);
                result.add(section);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public ArrayList<String> getSectionsInString() {
        String query = "select * from "
                       + TABLE_SECTIONS + " order by " + KEY_SECTION_ID;

        ArrayList<String> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String title = rs.getString(KEY_SECTION_TITLE);
                result.add(title);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public int getSectionByTitle(String title) {

        String query = "select " + KEY_SECTION_ID + " from "
                       + TABLE_SECTIONS + " where " + KEY_SECTION_TITLE + " = '" + title + "'";

        int id = -1;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                id = rs.getInt(KEY_SECTION_ID);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return id;
    }

    //</editor-fold>
    // <editor-fold desc="Notification">
    public void createNotify(Notify notify) {
        String query = "INSERT INTO " + TABLE_NOTIFY + "(" + KEY_NOTIFY_PERSONID + "," + KEY_NOTIFY_TEXT + ","
                       + KEY_NOTIFY_CREATED_DATE + "," + KEY_NOTIFY_SECTION_ID + "," + KEY_NOTIFY_SRC_ID + "," + KEY_NOTIFY_STATUS_ID
                       + ") VALUES (" + notify.getPersonId() + " , '" + notify.getText() + "', "
                       + notify.getCreatedDate() + ", " + notify.getSectionId() + ", " + notify.getSrcId() + ", " + notify.getStatus() + ")";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);

            query = "SELECT MAX(id) FROM users";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.first()) {
                int id = rs.getInt(1);
                notify.setId(id);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Notify getNotify(int notifyId) {

        String query = "select * from "
                       + TABLE_NOTIFY + " where" + " " + KEY_NOTIFY_ID + "=" + notifyId;

        Notify n = new Notify();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                int id = rs.getInt(KEY_NOTIFY_ID);
                String text = rs.getString(KEY_NOTIFY_TEXT);
                int personId = rs.getInt(KEY_NOTIFY_PERSONID);
                Long createdDate = rs.getLong(KEY_NOTIFY_CREATED_DATE);

                n.setId(id);

                n.setText(text);
                n.setPersonId(personId);
                n.setCreatedDate(createdDate);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return n;
    }

    public void setMyNotifiesToChecked(HttpServletRequest request) {
        String query = "UPDATE " + TABLE_NOTIFY + " SET "
                       + KEY_NOTIFY_STATUS_ID + " = 1 "
                       + " WHERE " + KEY_NOTIFY_PERSONID + "=" + Account.getCurrentPerson(request).getId();
        int count = 0;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void deleteNotify(int id) {
        String query = "DELETE * FROM " + TABLE_NOTIFY + " WHERE "
                       + KEY_NOTIFY_ID + "=" + id;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Notify> getAllMyNotifies(HttpServletRequest request) {
        String query = "select * from "
                       + TABLE_NOTIFY + " where " + KEY_NOTIFY_PERSONID + "=" + Account.getCurrentPerson(request).getId()
                       + " order by " + KEY_NOTIFY_CREATED_DATE + " desc ";

        ArrayList<Notify> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(KEY_NOTIFY_ID);
                int personId = rs.getInt(KEY_NOTIFY_PERSONID);
                int srcId = rs.getInt(KEY_NOTIFY_SRC_ID);
                String text = rs.getString(KEY_NOTIFY_TEXT);
                Long createdDate = rs.getLong(KEY_NOTIFY_CREATED_DATE);
                int sectionId = rs.getInt(KEY_NOTIFY_SECTION_ID);
                int status = rs.getInt(KEY_NOTIFY_STATUS_ID);

                Notify notify = new Notify(id, personId, text, createdDate, sectionId, srcId, status);
                result.add(notify);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public int getCountOfAllMyNewNotifies(HttpServletRequest request) {
        String query = "select count(*) from "
                       + TABLE_NOTIFY + " where " + KEY_NOTIFY_PERSONID
                       + "=" + Account.getCurrentPerson(request).getId() + " and " + KEY_NOTIFY_STATUS_ID + " = " + 0;
        int count = 0;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.first()) {
                count = rs.getInt(1);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return count;
    }

//</editor-fold>
// <editor-fold defaultstate="collapsed" desc="Bookmark">
    public void putExecutorInMyBookmarks(HttpServletRequest request, int executorId) {

        String query = "INSERT INTO " + TABLE_BOOKMARKS + "(" + KEY_BOOKMARK_PERSON_ID
                       + ", " + KEY_BOOKMARK_EXECUTOR_ID + ", " + KEY_BOOKMARK_ORDER_ID
                       + ") VALUES (" + Account.getCurrentPerson(request).getId() + " , "
                       + executorId + " , " + 0 + ")";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void putOrderInMyBookmarks(int orderId, HttpServletRequest request) {

        String query = "INSERT INTO " + TABLE_BOOKMARKS + "(" + KEY_BOOKMARK_PERSON_ID
                       + ", " + KEY_BOOKMARK_EXECUTOR_ID + ", " + KEY_BOOKMARK_ORDER_ID
                       + ") VALUES (" + Account.getCurrentPerson(request).getId() + " , "
                       + 0 + " , " + orderId + ")";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Bookmarks getBookmarkByOrderId(int orderId, HttpServletRequest request) {
        String query = "select * from "
                       + TABLE_BOOKMARKS + " where" + " " + KEY_BOOKMARK_ORDER_ID + "=" + orderId
                       + " and " + KEY_BOOKMARK_PERSON_ID + " = " + Account.getCurrentPerson(request).getId();

        Bookmarks b = new Bookmarks();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(KEY_BOOKMARK_PART_ID);
                int personId = rs.getInt(KEY_BOOKMARK_PERSON_ID);

                b.setId(id);
                b.setPersonId(personId);
                b.setExecutorId(0);
                b.setOrderId(orderId);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return b;
    }

    public Bookmarks getBookmarkByExecutorId(int executorId, HttpServletRequest request) {
        String query = "select * from " + TABLE_BOOKMARKS + " where"
                       + " " + KEY_BOOKMARK_EXECUTOR_ID + "=" + executorId
                       + " and " + KEY_BOOKMARK_PERSON_ID + " = " + Account.getCurrentPerson(request).getId();

        Bookmarks b = new Bookmarks();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(KEY_BOOKMARK_PART_ID);
                int personId = rs.getInt(KEY_BOOKMARK_PERSON_ID);

                b.setId(id);
                b.setPersonId(personId);
                b.setExecutorId(executorId);
                b.setOrderId(0);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return b;
    }

    public ArrayList<Bookmarks> getExecutorsListFromMyBookmarks(HttpServletRequest request) {
        String query = "select * from "
                       + TABLE_BOOKMARKS + " where " + KEY_BOOKMARK_PERSON_ID + " = " + Account.getCurrentPerson(request).getId()
                       + " and " + KEY_BOOKMARK_EXECUTOR_ID + " is not 0 "
                       + " order by " + KEY_BOOKMARK_PART_ID + " desc";
        ArrayList<Bookmarks> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(KEY_BOOKMARK_PART_ID);
                int personId = rs.getInt(KEY_BOOKMARK_PERSON_ID);
                int executorId = rs.getInt(KEY_BOOKMARK_EXECUTOR_ID);
                Bookmarks bookm = new Bookmarks(id, personId, executorId, 0);
                result.add(bookm);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public ArrayList<Bookmarks> getOrdersListFromMyBookmarks(HttpServletRequest request) {
        String query = "SELECT * FROM "
                       + TABLE_BOOKMARKS + " WHERE " + KEY_BOOKMARK_PERSON_ID + " = " + Account.getCurrentPerson(request).getId() + " AND " + KEY_BOOKMARK_ORDER_ID + " IS NOT 0 "
                       + " ORDER BY " + KEY_BOOKMARK_PART_ID + " DESC";
        ArrayList<Bookmarks> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(KEY_BOOKMARK_PART_ID);
                int personId = rs.getInt(KEY_BOOKMARK_PERSON_ID);
                int orderId = rs.getInt(KEY_BOOKMARK_ORDER_ID);
                Bookmarks bookm = new Bookmarks(id, personId, 0, orderId);
                result.add(bookm);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public void updateBookmark(Bookmarks bookmarks) {
        String query = "UPDATE " + TABLE_BOOKMARKS + " SET "
                       + KEY_BOOKMARK_PERSON_ID + "=" + bookmarks.getPersonId() + ", "
                       + KEY_BOOKMARK_EXECUTOR_ID + "= " + bookmarks.getExecutorId()
                       + " WHERE " + KEY_BOOKMARK_PART_ID + " = " + bookmarks.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteExecutorFromMyBookmarks(HttpServletRequest request, int executorId) {

        String query = "DELETE FROM " + TABLE_BOOKMARKS
                       + " WHERE " + KEY_BOOKMARK_EXECUTOR_ID + " = " + executorId + " and "
                       + KEY_BOOKMARK_PERSON_ID + " = " + Account.getCurrentPerson(request).getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteOrderFromMyBookmarks(int orderId, HttpServletRequest request) {

        String query = "DELETE FROM " + TABLE_BOOKMARKS
                       + " WHERE " + KEY_BOOKMARK_ORDER_ID + " = " + orderId + " and "
                       + KEY_BOOKMARK_PERSON_ID + " = " + Account.getCurrentPerson(request).getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // </editor-fold>
    //<editor-fold desc="EXECUTNPERSON">
    public int getExecutorIdByPersonId(int personId) {
        Person p = this.getPerson(personId);
        if (p == null) {
            return -1;
        }

        String query = "SELECT " + KEY_EXECUTORNPERSON_EXECUTOR_ID
                       + " FROM " + TABLE_EXECUTORNPERSON + " WHERE " + KEY_EXECUTORNPERSON_PERSON_ID + "= " + personId;

        int rId = -1;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.first()) {
                rId = rs.getInt(1);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return rId;
    }

    public void onExecutorCreate(Executor executor) {
        String query = "INSERT INTO " + TABLE_EXECUTORNPERSON + "(" + KEY_EXECUTORNPERSON_EXECUTOR_ID
                       + ", " + KEY_EXECUTORNPERSON_PERSON_ID
                       + ") VALUES (" + executor.getId() + " , "
                       + executor.getPersonId() + ")";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public int getPersonIdByExecutorId(int executorId) {
        Executor r = this.getExecutor(executorId);
        if (r == null) {
            return -1;
        }

        String query = "SELECT " + KEY_EXECUTORNPERSON_PERSON_ID
                       + " FROM " + TABLE_EXECUTORNPERSON + " WHERE " + KEY_EXECUTORNPERSON_EXECUTOR_ID + "= " + executorId;

        int rId = 0;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.first()) {
                rId = rs.getInt(1);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return rId;
    }

    public void onExecutorDelete(int executorId) {
        String query = "DELETE FROM " + TABLE_EXECUTORNPERSON + " WHERE "
                       + KEY_EXECUTORNPERSON_EXECUTOR_ID + " = "
                       + executorId;

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
    }

//</editor-fold>
//<editor-fold desc="Responses">
    public void addResponse(Response response) {
        String query = "INSERT INTO " + TABLE_RESPONSES + "(" + KEY_RESPONSES_ORDER_ID + ", " + KEY_RESPONSES_PERSON_ID
                       + ", " + KEY_RESPONSES_SUGGESTEDPRICE + ", " + KEY_RESPONSES_TEXT + ") VALUES (?,?,?,?)";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            con.setAutoCommit(false);
            PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, response.getOrderId());
            pstmt.setInt(2, response.getPersonId());
            pstmt.setDouble(3, response.getPrice());
            pstmt.setString(4, response.getText());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.first()) {
                response.setId(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Response getResponse(int id) {

        String query = "select * from " + TABLE_RESPONSES
                       + " where " + KEY_RESPONSES_ID + "=" + id;

        Response s = new Response();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                s = this.getResponseFromRs(rs);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return s;
    }

    public int getPersonIdByResponseId(int responsId) {

        String query = "SELECT " + KEY_RESPONSES_PERSON_ID
                       + " FROM " + TABLE_RESPONSES + " WHERE " + KEY_RESPONSES_ID + "= " + responsId;

        int s = 0;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                s = rs.getInt(1);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return s;
    }

    public void updateResponse(Response r) {
        String query = "UPDATE " + TABLE_RESPONSES + " SET "
                       + KEY_RESPONSES_SUGGESTEDPRICE + "=" + r.getPrice() + ", "
                       + KEY_RESPONSES_TEXT + "= " + r.getText() + ", "
                       + " WHERE " + KEY_RESPONSES_ID + "=" + r.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteResponse(int id) {
        String query = "DELETE * FROM " + TABLE_RESPONSES + " WHERE "
                       + KEY_RESPONSES_ID + "=" + id;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Integer> getRespondedPersonsIdListByOrderId(int orderId) {
        String query = "SELECT " + KEY_RESPONSES_PERSON_ID + " FROM " + TABLE_RESPONSES + " WHERE "
                       + KEY_RESPONSES_ORDER_ID + "=" + orderId;

        ArrayList<Integer> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                result.add(rs.getInt(1));
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public ArrayList<Response> getAllOrderResponsesByOrderId(int orderId) {
        String query = "select * from "
                       + TABLE_RESPONSES + " where " + KEY_RESPONSES_ORDER_ID + " = " + orderId + " order by " + KEY_RESPONSES_CREATEDDATE
                       + " asc";

        ArrayList<Response> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Response r = getResponseFromRs(rs);
                result.add(r);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;

    }

    private Response getResponseFromRs(ResultSet rs) throws Exception {
        int id = rs.getInt(KEY_RESPONSES_ID);
        int orderId = rs.getInt(KEY_RESPONSES_ORDER_ID);
        int personId = rs.getInt(KEY_RESPONSES_PERSON_ID);
        double price = rs.getDouble(KEY_RESPONSES_SUGGESTEDPRICE);
        String text = rs.getString(KEY_RESPONSES_TEXT);
        Long created = rs.getLong(KEY_RESPONSES_CREATEDDATE);
        Response r = new Response(id, orderId, personId, price, text);
        r.setCreatedDate(created);
        return r;
    }
//</editor-fold>

    //<editor-fold desc="Reviews">
    public void addReview(Review review) {
        String query = "INSERT INTO " + TABLE_REVIEWS + "(" + KEY_REVIEW_EXECUTOR_ID
                       + ", " + KEY_REVIEW_CUSTOMER_ID + ", " + KEY_REVIEW_REVIEW_TEXT + ", "
                       + KEY_REVIEW_ASSESSMENT + ", " + KEY_REVIEW_CREATED_DATE
                       + ") VALUES (?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            PreparedStatement pstmt
                              = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, review.getExecutrId());
            pstmt.setInt(2, review.getCustomerId());
            pstmt.setString(3, review.getReview_text());
            pstmt.setDouble(4, review.getAssessment());
            pstmt.setLong(5, review.getCreatedDate());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            int rId = 0;
            if (rs.next()) {
                rId = rs.getInt(1);
                review.setId(rId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Review getReview(int id) {

        String query = "select * from " + TABLE_REVIEWS + " where "
                       + " " + KEY_REVIEW_PART_ID + "=" + id;

        Review review = new Review();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.first()) {
                review = getReviewFromRs(rs);
                loadReviewAnswers(review);

            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return review;
    }

    private Review getReviewFromRs(ResultSet rs) throws Exception {
        int id = rs.getInt(KEY_REVIEW_PART_ID);
        int executorId = rs.getInt(KEY_REVIEW_EXECUTOR_ID);
        int customerId = rs.getInt(KEY_REVIEW_CUSTOMER_ID);
        int assessment = rs.getInt(KEY_REVIEW_ASSESSMENT);
        String text = rs.getString(KEY_REVIEW_REVIEW_TEXT);
        Long createddate = rs.getLong(KEY_REVIEW_CREATED_DATE);

        Review review = new Review(id, executorId, customerId, text, assessment);
        review.setCreatedDate(createddate);
        return review;
    }

    public ArrayList<Review> getAllPersonReviewByPersonId(int personId) {
        String query = "select * from "
                       + TABLE_REVIEWS + " where " + KEY_REVIEW_EXECUTOR_ID + " = " + personId + " order by "
                       + KEY_REVIEW_CREATED_DATE
                       + " desc";

        ArrayList<Review> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Review review = getReviewFromRs(rs);
                loadReviewAnswers(review);
                result.add(review);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getLeavedReviewPersonsIdList(int personId) {
        String query = "SELECT " + KEY_REVIEW_CUSTOMER_ID + " FROM " + TABLE_REVIEWS + " WHERE "
                       + KEY_REVIEW_EXECUTOR_ID + "=" + personId;

        ArrayList<Integer> arrID = new ArrayList();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                arrID.add(rs.getInt(1));
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return arrID;
    }

    public void updateReview(Review review) {
        String query = "UPDATE " + TABLE_REVIEWS + " SET "
                       + KEY_REVIEW_REVIEW_TEXT + "='" + review.getReview_text() + "', "
                       + KEY_REVIEW_ASSESSMENT + "=" + review.getAssessment()
                       + " WHERE " + KEY_REVIEW_PART_ID + " = " + review.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteReview(int id) {
        String query = "DELETE * FROM " + TABLE_REVIEWS + " WHERE "
                       + KEY_REVIEW_PART_ID + "=" + id;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//</editor-fold>
    //<editor-fold desc="ORDERNPERSON">
    public void onOrderCreate(Order order) {
        String query = "INSERT INTO " + TABLE_ORDERNPERSON + "(" + KEY_ORDERNPERSON_ORDER_ID
                       + ", " + KEY_ORDERNPERSON_CUSTOMER_ID
                       + ") VALUES (" + order.getId() + " , "
                       + order.getCustomerId() + ")";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public int getCustomerIdByOrderId(int orderId) {

        String query = "SELECT " + KEY_ORDERNPERSON_CUSTOMER_ID
                       + " FROM " + TABLE_ORDERNPERSON + " WHERE " + KEY_ORDERNPERSON_ORDER_ID + "= " + orderId;

        int id = 0;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.first()) {
                id = rs.getInt(1);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return id;
    }

    public void onOrderDelete(int orderId) {
        String query = "delete from " + TABLE_ORDERNPERSON + " where "
                       + KEY_ORDERNPERSON_ORDER_ID + "= " + orderId;

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
    }

//</editor-fold>
    //<editor-fold desc="Answer">
    public void addAnswer(Answer answer) {
        String query = "INSERT INTO " + TABLE_ANSWERS + "(" + KEY_ANSWER_REVIEW_ID + ", " + KEY_ANSWER_WHOANSWERS_ID
                       + ", " + KEY_ANSWER_WHOPOSTED_ID + ", " + KEY_ANSWER_TEXT + ", " + KEY_ANSWER_CREATED_DATE
                       + ") VALUES (?,?,?,?,?";
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            con.setAutoCommit(false);
            PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, answer.getReviewId());
            pstmt.setInt(2, answer.getWhoanswersId());
            pstmt.setInt(3, answer.getWhopostedId());
            pstmt.setString(4, answer.getText());
            pstmt.setLong(5, answer.getCreatedDate());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.first()) {
                answer.setId(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateAnswer(Answer answer) {
        String query = "UPDATE " + TABLE_ANSWERS + " SET "
                       + KEY_ANSWER_TEXT + "='" + answer.getText() + "'"
                       + " WHERE " + KEY_ANSWER_PART_ID + " = " + answer.getId();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteAnswer(int id) {
        String query = "DELETE * FROM " + TABLE_ANSWERS + " WHERE "
                       + KEY_ANSWER_PART_ID + "=" + id;
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Answer> getAllReviewAnswersByReviewId(int reviewId) {
        String query = "select * from "
                       + TABLE_ANSWERS + " where " + KEY_ANSWER_REVIEW_ID + " = " + reviewId + " order by "
                       + KEY_ANSWER_CREATED_DATE
                       + " desc";

        ArrayList<Answer> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Answer answer = getAnswerFromRs(rs);
                result.add(answer);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
        return result;
    }

    public void loadReviewAnswers(Review review) {
        String query = "SELECT * FROM "
                       + TABLE_ANSWERS + " JOIN " + TABLE_REVIEWNANSWERS + " ON "
                       + TABLE_ANSWERS + "." + KEY_ANSWER_PART_ID + "=" + TABLE_REVIEWNANSWERS
                       + "." + KEY_REVIEWNANSWERS_ANSWER_ID + " WHERE " + TABLE_REVIEWNANSWERS
                       + "." + KEY_REVIEWNANSWERS_REVIEW_ID + "=" + review.getId();

        try (Connection con = DriverManager.getConnection(URL, DBUSER, DBPASSWORD)) {
            Class.forName("com.mysql.jdbc.Driver");

            if (review.getAnswers().size() > 0) {
                review.getAnswers().clear();
            }

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Answer answer = getAnswerFromRs(rs);
                review.getAnswers().add(answer);
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

    }

    private Answer getAnswerFromRs(ResultSet rs) throws Exception {
        int id = rs.getInt(KEY_ANSWER_PART_ID);
        int reviewId = rs.getInt(KEY_ANSWER_REVIEW_ID);
        int whoanswersId = rs.getInt(KEY_ANSWER_WHOANSWERS_ID);
        int whoposted = rs.getInt(KEY_ANSWER_WHOPOSTED_ID);
        String text = rs.getString(KEY_ANSWER_TEXT);
        Long created = rs.getLong(KEY_ANSWER_CREATED_DATE);
        Answer answer = new Answer(id, reviewId, whoanswersId, whoposted, text, created);
        return answer;
    }
//</editor-fold>

}
