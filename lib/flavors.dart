import 'package:flutter/material.dart';

enum Flavor {
  mazda,
  nissan,
}

class F {
  static late final Flavor appFlavor;

  static String get name => appFlavor.name;

  static String get title {
    switch (appFlavor) {
      case Flavor.mazda:
        return 'Mazda';
      case Flavor.nissan:
        return 'Nissan';
    }
  }

  static ThemeData get theme {
    switch (appFlavor) {
      case Flavor.mazda:
        return ThemeData(          
          appBarTheme: AppBarTheme(
            backgroundColor: Colors.black,
          ),
        );
      case Flavor.nissan:
        return ThemeData(
          appBarTheme: AppBarTheme(
            backgroundColor: Colors.red,
          ),
        );
    }
  }

  static String get logoPath {
    switch (appFlavor) {
      case Flavor.mazda:
        return 'assets/icon/mazda_icon.png';
      case Flavor.nissan:
        return 'assets/icon/nissan_icon.png';
    }
  }

  static BoxDecoration get background {
  switch (appFlavor) {
    case Flavor.mazda:
      return BoxDecoration(
        color: Colors.black, 
      );
    case Flavor.nissan:
      
      return BoxDecoration(
        image: DecorationImage(
          image: AssetImage('assets/backgrounds/nissan_bg.jpg'),
          fit: BoxFit.cover,
          opacity: 0.5
        ),
      );
  }
}

}
