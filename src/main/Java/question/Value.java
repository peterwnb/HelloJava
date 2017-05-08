package question;

/**
 * Created by zzqno on 2017-5-8.
 */
public class Value {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(20);
        System.out.println(userInfo.getAge());
        UserInfo newUserInfo = new Value().getUserInfo(userInfo);
        System.out.println(newUserInfo.getAge());
    }

    public UserInfo getUserInfo(UserInfo userInfo) {
        userInfo = new UserInfo();
        userInfo.setAge(11);
        return userInfo;
    }

    static class UserInfo {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
