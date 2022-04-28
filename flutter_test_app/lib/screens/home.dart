import 'package:flutter_test_app/components/body.dart';
import 'package:flutter_test_app/components/keypad.dart';
import 'package:flutter_test_app/components/theme_changer.dart';
import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  State<Home> createState() => HomeState();
}

class HomeState extends State<Home> {
  bool _darkTheme = true;
  num? _firstSection;
  String? _operator;
  num? _secondSection;

  void changeTheme() {
    setState(() {
      debugPrint('ChangeTheme');
      _darkTheme = !_darkTheme;
    });
  }

  void setNum(num number) {
    setState(() {
      debugPrint('setNum: ' + number.toString());

      if (_operator == null) {
        if (_firstSection != null) {
          _firstSection = num.parse(_firstSection.toString() + number.toString());
        } else {
          _firstSection = number;
        }
      } else {
        if (_secondSection != null) {
          _secondSection = num.parse(_secondSection.toString() + number.toString());
        } else {
          _secondSection = number;
        }
      }


    });
  }

  void setOperator(String operator) {
    setState(() {
      debugPrint('setOperator: ' + operator.toString());

      if (_secondSection == null) {
        _operator = operator;
        return;
      }

      if (_operator == "+") {
        _firstSection = (_firstSection! + _secondSection!)!;
      }

      if (_operator == "-") {
        _firstSection = (_firstSection! - _secondSection!)!;
      }

      if (_operator == "/") {
        _firstSection = (_firstSection! / _secondSection!)!;
      }

      if (_operator == "*") {
        _firstSection = (_firstSection! * _secondSection!)!;
      }

      if (operator == "=") {
        _operator = null;
      } else {
        _operator = operator;
      }
      _secondSection = null;
    });
  }

  void setClear(bool onlyOne) {
    setState(() {
      debugPrint('setClear: ' + onlyOne.toString());

      if (onlyOne) {
        if (_secondSection != null) {
          String secondFieldString = _secondSection.toString();

          if (secondFieldString.length > 1) {
            _secondSection = num.parse(secondFieldString.substring(0, secondFieldString.length - 1));
          } else {
            _secondSection = null;
          }
        } else if (_operator != null) {
          _operator = null;
        } else if (_firstSection != null) {
          String firstFieldString = _firstSection.toString();

          if (firstFieldString.length > 1) {
            _firstSection = num.parse(firstFieldString.substring(0, firstFieldString.length - 1));
          } else {
            _firstSection = null;
          }
        }
      } else {
        _firstSection = null;
        _operator = null;
        _secondSection = null;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        leading: Padding(
          padding: const EdgeInsets.all(5.0),
          child: ChangeThemeButton(
            onPressed: changeTheme,
            darkTheme: _darkTheme,
          ),
        ),
      ),
      extendBodyBehindAppBar: true,
      body: AnimatedContainer(
        duration: const Duration(milliseconds: 400),
        decoration: BoxDecoration(
          gradient: LinearGradient(
            colors: [
              _darkTheme ? const Color(0xFF1E1E1E) : const Color(0xFFFFFFFF),
              _darkTheme ? const Color(0xFF666666) : const Color(0xFFD2D2D2),
            ],
            begin: Alignment.topCenter,
            end: Alignment.bottomCenter,
          ),
        ),
        child: Column(
          children: [
            CalculatorBody(
              firstSection: _firstSection,
              operator: _operator,
              secondSection: _secondSection,
              darkTheme: _darkTheme,
            ),
            KeyPad(
              darkTheme: _darkTheme,
              onNumberSelect: (num number) {
                setNum(number);
              },
              onOperatorSelect: (String operator) {
                setOperator(operator);
              },
              onClearSelect: (bool onlyOne) {
                setClear(onlyOne);
              },
            ),
          ],
        ),
      ),
    );
  }
}
