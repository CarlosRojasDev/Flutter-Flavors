import 'package:flutter/material.dart';
import '../flavors.dart';

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(            
      body: Container(
        decoration: F.background,
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset(F.logoPath, height: 200),
              Text('${F.title} Application'),
            ],
          ),
        ),
      ),
    );
  }
}
