import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class complex {


    @Test
    public void complex1() {
        String response = payload.CoursePrice();
        JsonPath js=new JsonPath(response);
        int count=js.getInt("courses.size()");
        int purchaseAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println("Total no of courses are "+count);
        System.out.println("Purchase amount is "+purchaseAmount);
        System.out.println("Title of the First course is "+js.getString("courses[0].title"));
        for(int i=0;i<count;i++){
            System.out.println("Title : "+js.getString("courses["+i+"].title")+"  Price : "+js.getInt("courses["+i+"].price"));
        }

        for(int i=0;i<count;i++){
            if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")){
                System.out.println("Copies of RPA is "+js.getString("courses["+i+"].copies"));
                break;
            }
        }
        int sum=0;
        for(int i=0;i<count;i++){
            sum+=js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies");
        }
        System.out.println("Total sum is "+sum);
        Assert.assertEquals(sum,purchaseAmount);


    }
}
