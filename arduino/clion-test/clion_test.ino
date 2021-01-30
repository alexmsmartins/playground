//#include <Arduino.h>
#include <avr/io.h>
#include <util/delay.h>
#define F_CPU  16000000UL
int main(void)
{
    DDRB |= 0B00100000;
    while (1)
    {
        PORTB |= 0B00100000;
        _delay_ms(5000);
        PORTB &= 0B11011111;
        _delay_ms(5000);
    }
}
// void setup()
// {
//     // initialize digital pin LED_BUILTIN as an output.
//     pinMode(LED_BUILTIN, OUTPUT);
// }
// // the loop function runs over and over again forever
// void loop() {
//     digitalWrite(LED_BUILTIN, HIGH);   // turn the LED on (HIGH is the voltage level)
//     delay(40);                       // wait for a second
//     digitalWrite(LED_BUILTIN, LOW);    // turn the LED off by making the voltage LOW
//     delay(40);                       // wait for a second
// }
