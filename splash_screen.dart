import 'dart:async';
// import 'package:demo/onboarding_screen.dart';
import 'package:demo/onboarding_screen.dart';
import 'package:flutter/material.dart';

class SplashScreen extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => StartState();
}

class StartState extends State<SplashScreen> {
  @override
  Widget build(BuildContext context) {
    return initScreen(context);
  }

  @override
  void initState() {
    super.initState();
    startTimer();
  }

  startTimer() async {
    var duration = Duration(seconds: 5);
    return new Timer(duration, route);
  }

  route() {
    Navigator.pushReplacement(
        context, MaterialPageRoute(builder: (context) => OnboardingScreen()));
  }

  initScreen(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Container(
              child: Image.asset('assets/images/logo.png'),
            ),
            Padding(padding: EdgeInsets.only(top: 20.0)),
            Text(
              "BOOVA",
              style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 30.0,
                color: Colors.black,
              ),
            ),
            Padding(padding: EdgeInsets.only(top: 20.0)),
            CircularProgressIndicator(
              backgroundColor: Colors.black,
              strokeWidth: 1,
            )
          ],
        ),
      ),
    );
  }
}
