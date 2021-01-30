/** This program turns a LED on 
 * the setup function runs once when you press reset or power the board
 */
int switch_LED = HIGH;

void setup() {
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(3, OUTPUT); 
  pinMode(2, INPUT_PULLUP);
}

bool button_was_down_before = false;

bool is_button_down(int button_input);
// the loop function runs over and over again forever
void loop() {
  int button_is_down = digitalRead(2) == HIGH;

  if(button_is_down == true && button_is_down != button_was_down_before){
    switch_LED = switch_the_LED(switch_LED);
  } 
  digitalWrite(3, switch_LED);

  button_was_down_before = button_is_down;
}

int switch_the_LED(int a){
  if(a == HIGH)
    return LOW;
  if(a == LOW)
    return HIGH;
}

