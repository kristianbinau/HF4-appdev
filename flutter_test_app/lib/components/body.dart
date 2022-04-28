import 'package:flutter/material.dart';

class CalculatorBody extends StatelessWidget {
  const CalculatorBody({
    Key? key,
    num? firstSection,
    String? operator,
    num? secondSection,
    required bool darkTheme,
  })  : _firstSection = firstSection,
        _operator = operator,
        _secondSection = secondSection,
        _darkTheme = darkTheme,
        super(key: key);

  final num? _firstSection;
  final String? _operator;
  final num? _secondSection;
  final bool _darkTheme;

  String getText() {
    String returnString = "";

    if (_firstSection != null) {
      debugPrint('getText: FirstSection:' + _firstSection.toString());
      returnString = returnString + _firstSection.toString();
    }

    if (_operator != null) {
      debugPrint('getText: Operator:' + _operator.toString());
      returnString = returnString + _operator.toString();
    }

    if (_secondSection != null) {
      debugPrint('getText: SecondSection:' + _secondSection.toString());
      returnString = returnString + _secondSection.toString();
    }
    debugPrint('getText: ' + returnString.toString());

    return returnString;
  }

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
        padding: const EdgeInsets.all(20),
        alignment: Alignment.bottomRight,
        child: Text(
          getText(),
          style: Theme.of(context).textTheme.headline2?.copyWith(
                color: _darkTheme ? Colors.white : Colors.black,
              ),
        ),
      ),
    );
  }
}
