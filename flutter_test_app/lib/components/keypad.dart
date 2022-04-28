import 'package:flutter_test_app/components/button.dart';
import 'package:flutter/material.dart';

class KeyPad extends StatelessWidget {
  final bool darkTheme;
  const KeyPad({
    Key? key,
    required this.onNumberSelect,
    required this.onOperatorSelect,
    required this.onClearSelect,
    this.darkTheme = true,
  }) : super(key: key);

  final setNumberCallback onNumberSelect;
  final setOperatorCallback onOperatorSelect;
  final setClearCallback onClearSelect;

  @override
  Widget build(BuildContext context) {
    return AnimatedContainer(
      duration: const Duration(milliseconds: 300),
      decoration: BoxDecoration(
        borderRadius: const BorderRadius.only(
          topLeft: Radius.circular(20),
          topRight: Radius.circular(20),
        ),
        gradient: LinearGradient(
          colors: [
            darkTheme ? const Color(0xFF383838) : const Color(0xFFA1A1A1),
            darkTheme ? const Color(0xFF666666) : const Color(0xFF6C6C6C),
          ],
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
        ),
      ),
      padding: const EdgeInsets.all(10.0),
      child: Column(
        children: [
          Row(
            children: [
              CalculatorButton(
                buttonText: "AC",
                onPressed: () {
                  onClearSelect(false);
                },
                type: "function",
              ),
              CalculatorButton(
                buttonText: "BS",
                onPressed: () {
                  onClearSelect(true);
                },
                type: "function",
              ),
              CalculatorButton(
                buttonText: "",
                onPressed: () {},
                type: "function",
              ),
              CalculatorButton(
                buttonText: "/",
                onPressed: () {},
                type: "operator",
              ),
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              CalculatorButton(
                buttonText: "7",
                onPressed: () {
                  onNumberSelect(7);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "8",
                onPressed: () {
                  onNumberSelect(8);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "9",
                onPressed: () {
                  onNumberSelect(9);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "*",
                onPressed: () {
                  onOperatorSelect("*");
                },
                type: "operator",
              ),
            ],
          ),

          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              CalculatorButton(
                buttonText: "4",
                onPressed: () {
                  onNumberSelect(4);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "5",
                onPressed: () {
                  onNumberSelect(5);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "6",
                onPressed: () {
                  onNumberSelect(6);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "-",
                onPressed: () {
                  onOperatorSelect("-");
                },
                type: "operator",
              ),
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              CalculatorButton(
                buttonText: "1",
                onPressed: () {
                  onNumberSelect(1);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "2",
                onPressed: () {
                  onNumberSelect(2);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "3",
                onPressed: () {
                  onNumberSelect(3);
                },
                type: "number",
              ),
              CalculatorButton(
                buttonText: "+",
                onPressed: () {
                  onOperatorSelect("+");
                },
                type: "operator",
              ),
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              CalculatorButton(
                buttonText: "0",
                onPressed: () {
                  onNumberSelect(0);
                },
                flex: 2,
              ),
              CalculatorButton(
                buttonText: "",
                onPressed: () {},
                type: "number",
              ),
              CalculatorButton(
                buttonText: "=",
                onPressed: () {
                  onOperatorSelect("=");
                },
                type: "operator",
              ),
            ],
          )
        ],
      ),
    );
  }
}

typedef setNumberCallback = void Function(num number);
typedef setOperatorCallback = void Function(String operator);
typedef setClearCallback = void Function(bool onlyOne);