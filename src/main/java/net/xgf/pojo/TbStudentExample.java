package net.xgf.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbStudentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStunameIsNull() {
            addCriterion("stuName is null");
            return (Criteria) this;
        }

        public Criteria andStunameIsNotNull() {
            addCriterion("stuName is not null");
            return (Criteria) this;
        }

        public Criteria andStunameEqualTo(String value) {
            addCriterion("stuName =", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotEqualTo(String value) {
            addCriterion("stuName <>", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameGreaterThan(String value) {
            addCriterion("stuName >", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameGreaterThanOrEqualTo(String value) {
            addCriterion("stuName >=", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLessThan(String value) {
            addCriterion("stuName <", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLessThanOrEqualTo(String value) {
            addCriterion("stuName <=", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLike(String value) {
            addCriterion("stuName like", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotLike(String value) {
            addCriterion("stuName not like", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameIn(List<String> values) {
            addCriterion("stuName in", values, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotIn(List<String> values) {
            addCriterion("stuName not in", values, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameBetween(String value1, String value2) {
            addCriterion("stuName between", value1, value2, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotBetween(String value1, String value2) {
            addCriterion("stuName not between", value1, value2, "stuname");
            return (Criteria) this;
        }

        public Criteria andExamcodeIsNull() {
            addCriterion("examCode is null");
            return (Criteria) this;
        }

        public Criteria andExamcodeIsNotNull() {
            addCriterion("examCode is not null");
            return (Criteria) this;
        }

        public Criteria andExamcodeEqualTo(String value) {
            addCriterion("examCode =", value, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeNotEqualTo(String value) {
            addCriterion("examCode <>", value, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeGreaterThan(String value) {
            addCriterion("examCode >", value, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeGreaterThanOrEqualTo(String value) {
            addCriterion("examCode >=", value, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeLessThan(String value) {
            addCriterion("examCode <", value, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeLessThanOrEqualTo(String value) {
            addCriterion("examCode <=", value, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeLike(String value) {
            addCriterion("examCode like", value, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeNotLike(String value) {
            addCriterion("examCode not like", value, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeIn(List<String> values) {
            addCriterion("examCode in", values, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeNotIn(List<String> values) {
            addCriterion("examCode not in", values, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeBetween(String value1, String value2) {
            addCriterion("examCode between", value1, value2, "examcode");
            return (Criteria) this;
        }

        public Criteria andExamcodeNotBetween(String value1, String value2) {
            addCriterion("examCode not between", value1, value2, "examcode");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andDeparmentIsNull() {
            addCriterion("deparment is null");
            return (Criteria) this;
        }

        public Criteria andDeparmentIsNotNull() {
            addCriterion("deparment is not null");
            return (Criteria) this;
        }

        public Criteria andDeparmentEqualTo(String value) {
            addCriterion("deparment =", value, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentNotEqualTo(String value) {
            addCriterion("deparment <>", value, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentGreaterThan(String value) {
            addCriterion("deparment >", value, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentGreaterThanOrEqualTo(String value) {
            addCriterion("deparment >=", value, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentLessThan(String value) {
            addCriterion("deparment <", value, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentLessThanOrEqualTo(String value) {
            addCriterion("deparment <=", value, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentLike(String value) {
            addCriterion("deparment like", value, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentNotLike(String value) {
            addCriterion("deparment not like", value, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentIn(List<String> values) {
            addCriterion("deparment in", values, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentNotIn(List<String> values) {
            addCriterion("deparment not in", values, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentBetween(String value1, String value2) {
            addCriterion("deparment between", value1, value2, "deparment");
            return (Criteria) this;
        }

        public Criteria andDeparmentNotBetween(String value1, String value2) {
            addCriterion("deparment not between", value1, value2, "deparment");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIsNull() {
            addCriterion("seatNumber is null");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIsNotNull() {
            addCriterion("seatNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSeatnumberEqualTo(Integer value) {
            addCriterion("seatNumber =", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotEqualTo(Integer value) {
            addCriterion("seatNumber <>", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberGreaterThan(Integer value) {
            addCriterion("seatNumber >", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("seatNumber >=", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLessThan(Integer value) {
            addCriterion("seatNumber <", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLessThanOrEqualTo(Integer value) {
            addCriterion("seatNumber <=", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIn(List<Integer> values) {
            addCriterion("seatNumber in", values, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotIn(List<Integer> values) {
            addCriterion("seatNumber not in", values, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberBetween(Integer value1, Integer value2) {
            addCriterion("seatNumber between", value1, value2, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("seatNumber not between", value1, value2, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andHeadurlIsNull() {
            addCriterion("headUrl is null");
            return (Criteria) this;
        }

        public Criteria andHeadurlIsNotNull() {
            addCriterion("headUrl is not null");
            return (Criteria) this;
        }

        public Criteria andHeadurlEqualTo(String value) {
            addCriterion("headUrl =", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlNotEqualTo(String value) {
            addCriterion("headUrl <>", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlGreaterThan(String value) {
            addCriterion("headUrl >", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlGreaterThanOrEqualTo(String value) {
            addCriterion("headUrl >=", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlLessThan(String value) {
            addCriterion("headUrl <", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlLessThanOrEqualTo(String value) {
            addCriterion("headUrl <=", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlLike(String value) {
            addCriterion("headUrl like", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlNotLike(String value) {
            addCriterion("headUrl not like", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlIn(List<String> values) {
            addCriterion("headUrl in", values, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlNotIn(List<String> values) {
            addCriterion("headUrl not in", values, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlBetween(String value1, String value2) {
            addCriterion("headUrl between", value1, value2, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlNotBetween(String value1, String value2) {
            addCriterion("headUrl not between", value1, value2, "headurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlIsNull() {
            addCriterion("healthUrl is null");
            return (Criteria) this;
        }

        public Criteria andHealthurlIsNotNull() {
            addCriterion("healthUrl is not null");
            return (Criteria) this;
        }

        public Criteria andHealthurlEqualTo(String value) {
            addCriterion("healthUrl =", value, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlNotEqualTo(String value) {
            addCriterion("healthUrl <>", value, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlGreaterThan(String value) {
            addCriterion("healthUrl >", value, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlGreaterThanOrEqualTo(String value) {
            addCriterion("healthUrl >=", value, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlLessThan(String value) {
            addCriterion("healthUrl <", value, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlLessThanOrEqualTo(String value) {
            addCriterion("healthUrl <=", value, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlLike(String value) {
            addCriterion("healthUrl like", value, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlNotLike(String value) {
            addCriterion("healthUrl not like", value, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlIn(List<String> values) {
            addCriterion("healthUrl in", values, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlNotIn(List<String> values) {
            addCriterion("healthUrl not in", values, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlBetween(String value1, String value2) {
            addCriterion("healthUrl between", value1, value2, "healthurl");
            return (Criteria) this;
        }

        public Criteria andHealthurlNotBetween(String value1, String value2) {
            addCriterion("healthUrl not between", value1, value2, "healthurl");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idCard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idCard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idCard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idCard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idCard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idCard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idCard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idCard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idCard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idCard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idCard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idCard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idCard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idCard not between", value1, value2, "idcard");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}