package com.example.lazycoder.health.Database;

import android.content.Context;

import com.example.lazycoder.health.ModelClass.ProductModel;
import com.example.lazycoder.health.R;

/**
 * Created by lazycoder on 2/9/18.
 */

public class SampleData {
    private ProductDatabase productDB;

    public SampleData(Context context) {
        productDB = new ProductDatabase(context);
    }

    public void storeSomeSampleData() {

        //if no data present on database then insert some row data
        if (!productDB.haveAnyData()){
            sampleFoodData();
            sampleDoctorData();
            sampleAccessoriseData();
            sampleMedicineData();
            sampleGymData();
        }
    }


    //Note:
    //String.valueOf(Integer.valueOf(R.drawable.doctor2))
    //first we convert

    //Sample Food Data
    public void sampleFoodData(){
        productDB.insertProduct(new ProductModel(
                "199",
                "Organic Honey",
                "no added preservatives",
                "No added preservatives no added preservatives no added preservatives no added preservatives",
                String.valueOf(Integer.valueOf(R.drawable.honey)),
                "Narayan gonj",
                "Food",
                "Prince Bazar",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));

        productDB.insertProduct(new ProductModel(
                "200",
                "Grapes",
                "Eat fresh and juicy grapes",
                "Eat fresh and juicy grapes that are hygienically packed and deliciously tasty. The Fresho brand is renowned for delivering the best of produce, sourced fresh from farms and packaged hygienically to increase the shelf life.",
                String.valueOf(Integer.valueOf(R.drawable.grapes)),
                "Mirpur-12",
                "Food",
                "Prince Bazar",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "201",
                "Orange",
                "Orange kinnow is a high-yield mandarin",
                "Orange kinnow is a high-yield mandarin orange that is cultivated in various parts of India and Pakistan. It was first developed in the University of California by via hybrid of King (Citrus nobilis) and Willow Leaf (Citrus x deliciosa).",
                String.valueOf(Integer.valueOf(R.drawable.orange)),
                "Mirpur-12",
                "Food",
                "Prince Bazar",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "202",
                "Strawberry",
                "Fresho Strawberries are bright red fruits",
                "Fresho Strawberries are bright red fruits with juicy texture inside. Comes with a unique tangy-sweet taste that lingers on your mouth. Fresho is our brand of fresh fruits and vegetables which are individually handpicked everyday by our trained farmers.",
                String.valueOf(Integer.valueOf(R.drawable.strawberrie)),
                "Mirpur-12",
                "Food",
                "Prince Bazar",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "203",
                "Mosambi",
                "Sugary, tangy and juicy",
                "Sugary, tangy and juicy, Fresho mosambis are versatile fruits which have yellow skins and are very low in calories. Sweet limes are also rich in many nutrients and can fight many diseases. They are obtained from the most reputed growers and stored carefully to retain their taste and flavour. ",
                String.valueOf(Integer.valueOf(R.drawable.mosambi)),
                "Mirpur-12",
                "Food",
                "Prince Bazar",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));


    }


    //----------------------Sample Doctor Data---------------------

    public void sampleDoctorData(){
        productDB.insertProduct(new ProductModel(
                "100",
                "Dr Jagan Mazmudar",
                "Child Specialist",
                "Dr. Jagan is a reputed Child Specialist with a rich working experience of 36 years. His areas of specialization includes Respiratory Problems, Pneumonia, Gastroenteritis, Dysentery, Infectious Hepatitis A, Worm Infestation, Infectious Diseases: Malaria, Measles, Primary Tuberculosis, Hematology, Epilepsy and other Neonatal Diseases.",
                String.valueOf(Integer.valueOf(R.drawable.jagan)),
                "Dhanmondi-32",
                "Doctor",
                "Appolo Hospital",
                "Road-07,Hosue-658",
                "Dhaka-1216",
                "01772465164"
        ));

        productDB.insertProduct(new ProductModel(
                "101",
                "Dr. Amarjeet Bhatia",
                "Psychology Specialist",
                "Dr. Amarjeet Bhatia is a name to reckon with in the field of General Medical Practice. His rich experience and vast number of customers are a testament to his brilliance. He has 16+ years of experience in some of the Marquee Hospitals of India like Apollo, Batra and Fortis Hospitals. He has an expanded knowledge base and a good grasp of General Medicine.",
                String.valueOf(Integer.valueOf(R.drawable.dr_amarjeet)),
                "Dhanmondi-2",
                "Doctor",
                "Fortis Hospitals",
                "Road-07,Hosue-658",
                "Dhaka-1216",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "102",
                "Dr. Vasavi Sunki",
                "Psychologist",
                "Dr. Vasavi is a Clinical Psychologist with 16 years of experience as a Consultant Psychologist. Her areas of expertise include Marital Counselling, Counselling of Children, and Psycho Therapies etc. She has worked with very well-known institutions of the country- Border Roads Organisation, Ministry of Defence, Cyberabad Police Commissionerate and Ankura Hospitals",
                String.valueOf(Integer.valueOf(R.drawable.vasavi)),
                "Mirpur-2",
                "Doctor",
                "Bardem Hospital",
                "Road-07,Hosue-658",
                "Dhaka-1216",
                "01772465164"
        ));

        productDB.insertProduct(new ProductModel(
                "103",
                "Dr. Gulneer Puri",
                "Diet Specialist",
                "Dt. Gulneer Puri is a wonderful Diet Specialist who has successfully guided her patients towards a better lifestyle by suggesting innovative diet tips. She has a rich experience of 9+ years in area of Clinical Dietetics and Nutrition Weight Management, Diabetic and other Therapeutic Diets.",
                String.valueOf(Integer.valueOf(R.drawable.gulneer)),
                "Dhanmondi-14",
                "Doctor",
                "Appolo Hospital",
                "Road-07,Hosue-658",
                "Dhaka-1216",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "104",
                "Dr. Puneet Madan",
                "Dermatologist",
                "Dr. Puneet Madan is a leading Dermatologist with 9 years of experience. His expertise includes Skin Problems, Eczema, Acne, Psoriasis, and Nail Infections. He has worked in best hospitals of Delhi – Ram Manohar Lohia Hospital, Deen Dayal Upadhyaya Hospital and GTB Hospital.",
                String.valueOf(Integer.valueOf(R.drawable.dr_puneet)),
                "Dhanmondi-6",
                "Doctor",
                "GTB Hospital",
                "Road-07,Hosue-658",
                "Dhaka-1216",
                "01772465164"
        ));

        productDB.insertProduct(new ProductModel(
                "105",
                "Dr. Krishan Sharma",
                "Psychiatrist and Sexologist",
                "Dr. Krishan is a well-respected Psychiatrist and Sexologist with 8+ years of experience in assessment, diagnosis and treatment of Psychiatric disorders & Sexology Disorders across different age groups. His Strong values and a solid work ethic have made him one of the leading Specialists in India.",
                String.valueOf(Integer.valueOf(R.drawable.dr_krishan)),
                "Dhanmondi-32",
                "Doctor",
                "Appolo Hospital",
                "Road-07,Hosue-658",
                "Dhaka-1216",
                "01772465164"
        ));
    }


    //----------------------Sample Accessorise Data---------------------

    public void sampleAccessoriseData(){
        productDB.insertProduct(new ProductModel(
                "300",
                "Fitbit Flex 2",
                "Track activity & sleep",
                "Track activity & sleep and get notifications with this ultra-slim swim-proof wristband. The removable tracker fits in band, bangle & pendant accessories.",
                String.valueOf(Integer.valueOf(R.drawable.fitbit)),
                "Bonani",
                "fitness",
                "Shoppers Shop",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "301",
                "Hand Weights",
                "Cast iron wrapped in a thick coat of durable neoprene",
                " Cast iron wrapped in a thick coat of durable neoprene for a comfy grip that is gentle on hands and doesn’t require gloves\n" +
                        "Stylish and modern look with bright, color-coded weight increments and large, clear numbers. It’s quick and easy to grab the right weight for your routine\n" +
                        "Oblong design resists rolling, while the thick handles enhance and strengthen grip\n" +
                        "Compact size is easy to store and perfect for travel. Easy to clean neoprene is great for indoor and outdoor use\n" +
                        "Heavy weight exercises build muscle mass and strengthen the core; lighter weights add resistance to aerobic exercises and jogging, physical therapy, even yoga ",
                String.valueOf(Integer.valueOf(R.drawable.weights)),
                "Bonani",
                "fitness",
                "Shoppers Shop",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "302",
                "Jump Rope",
                "Adjustable Cable Rapid Ball Bearings",
                "Adjustable Cable Rapid Ball Bearings & Anti-Slip Handles - Best for Double Unders, Speed, WOD, MMA, Boxing, Skipping Exercise, Jumping Workout ",
                String.valueOf(Integer.valueOf(R.drawable.jumproper)),
                "Bonani",
                "fitness",
                "Shoppers Shop",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "303",
                "Yoga Mat",
                "Sivan Health and Fitness",
                "Sivan Health and Fitness 1/2-InchExtra Thick 71-Inch Long NBR Comfort Foam Yoga Mat for Exercise, Yoga, and Pilates",
                String.valueOf(Integer.valueOf(R.drawable.yogamat)),
                "Bonani",
                "fitness",
                "Shoppers Shop",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "304",
                "Dumbbells",
                "Yes4All Adjustable Dumbbells",
                        "Yes4All Adjustable Dumbbells 40, 50, 52.5 , 60, 105 to 200 lbs",
                String.valueOf(Integer.valueOf(R.drawable.dumbbells)),
                "Bonani",
                "fitness",
                "Shoppers Shop",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "305",
                "Exercise Bike",
                "Home Exercise Bike",
                "ProForm Le Tour de France Pro 5.0 Home Exercise Bike w/ Touchscreen & Bluetooth",
                String.valueOf(Integer.valueOf(R.drawable.exercisebike)),
                "Bonani",
                "fitness",
                "Shoppers Shop",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));


    }

    //----------------------Sample Medicine Data---------------------

    public void sampleMedicineData(){
        productDB.insertProduct(new ProductModel(
                "400",
                "Aloke Medicine corner",
                "All types of diabetics medicine",
                "All types of diabetics medicine All types of diabetics medicine",
                String.valueOf(Integer.valueOf(R.drawable.medicine1)),
                "Bonani",
                "medicine",
                "Hock Medicine",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "401",
                "Sonar Bangla Pharmacy",

                        "Bangabandhu Sheikh Mojib Medical University Gate No-03",

                        "Bangabandhu Sheikh Mojib Medical University Gate No-03 ",
                String.valueOf(Integer.valueOf(R.drawable.medicine2)),
                "Shahbag",
                "medicine",
                "Sonar Bangla Pharmacy",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "402",
                "M/s. Mukti Drug Store ",
                "1/2, Shahbag Biponi Bitan",
                "1/2, Shahbag Biponi Bitan",
                String.valueOf(Integer.valueOf(R.drawable.medicine3)),
                "Shahbag",
                "medicine",
                "Hock Medicine",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "403",

                        "Rahman Pharmacy ",

                        "3/2/A, Shahbag Biponi Bitan",

                        "3/2/A, Shahbag Biponi Bitan",
                String.valueOf(Integer.valueOf(R.drawable.medicine4)),
                "Bonani",
                "medicine",
                "Hock Medicine",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));

    }


    //----------------------Sample Gym Data---------------------
    public void sampleGymData(){
        productDB.insertProduct(new ProductModel(
                "500",
                "Sea Shell Gym Center",
                "Dreams hair & beauty corner",
                "Welcome you to Dreams hair & beauty corner and wish you every satisfaction here. Dreams provides services such as Hair Styling, Bridal make-up, Party makeup, Model makeup, Hair Cuts, Facial, Wax, Padi care and manicure, Oil Massage, Hair Color, Mehedi ",
                String.valueOf(Integer.valueOf(R.drawable.gym1)),
                "Dhanmondi-32",
                "gym",
                "Sea Shell",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "501",
                "Sea Shell Gym Center",
                "Dreams hair & beauty corner",
                "Welcome you to Dreams hair & beauty corner and wish you every satisfaction here. Dreams provides services such as Hair Styling, Bridal make-up, Party makeup, Model makeup, Hair Cuts, Facial, Wax, Padi care and manicure, Oil Massage, Hair Color, Mehedi ",
                String.valueOf(Integer.valueOf(R.drawable.gym1)),
                "Dhanmondi-32",
                "gym",
                "Sea Shell",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "502",
                "Sea Shell Gym Center",
                "Dreams hair & beauty corner",
                "Welcome you to Dreams hair & beauty corner and wish you every satisfaction here. Dreams provides services such as Hair Styling, Bridal make-up, Party makeup, Model makeup, Hair Cuts, Facial, Wax, Padi care and manicure, Oil Massage, Hair Color, Mehedi ",
                String.valueOf(Integer.valueOf(R.drawable.gym1)),
                "Dhanmondi-32",
                "gym",
                "Sea Shell",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "503",
                "Sea Shell Gym Center",
                "Dreams hair & beauty corner",
                "Welcome you to Dreams hair & beauty corner and wish you every satisfaction here. Dreams provides services such as Hair Styling, Bridal make-up, Party makeup, Model makeup, Hair Cuts, Facial, Wax, Padi care and manicure, Oil Massage, Hair Color, Mehedi ",
                String.valueOf(Integer.valueOf(R.drawable.gym1)),
                "Dhanmondi-32",
                "gym",
                "Sea Shell",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));
        productDB.insertProduct(new ProductModel(
                "504",
                "Sea Shell Gym Center",
                "Dreams hair & beauty corner",
                "Welcome you to Dreams hair & beauty corner and wish you every satisfaction here. Dreams provides services such as Hair Styling, Bridal make-up, Party makeup, Model makeup, Hair Cuts, Facial, Wax, Padi care and manicure, Oil Massage, Hair Color, Mehedi ",
                String.valueOf(Integer.valueOf(R.drawable.gym1)),
                "Dhanmondi-32",
                "gym",
                "Sea Shell",
                "Main road,Shop-09",
                "Dhaka-1214",
                "01772465164"
        ));


    }

}
