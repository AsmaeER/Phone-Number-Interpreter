package com.phonenumberinterpretationtest;

import org.junit.Test;

import com.phonenumberinterpretation.PhoneNumberInterpreter;

import static org.junit.Assert.*;

public class PhoneNumberInterpreterTest {

    @Test
    public void testInterpretNumberSequenceValidInput() {
        String input = "30 2 5 58";
        String expectedOutput = "302558";
        assertEquals(expectedOutput, PhoneNumberInterpreter.interpretNumberSequence(input));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInterpretNumberSequenceInvalidInput() {
        String input = "abc 123";
        PhoneNumberInterpreter.interpretNumberSequence(input);
    }
    
    @Test
    public void testValidatePhoneNumberValid10Digits() {
        String number = "2106930664";
        String expectedOutput = "[phone number: VALID]";
        assertEquals(expectedOutput, PhoneNumberInterpreter.validatePhoneNumber(number));
    }
    
    @Test
    public void testValidatePhoneNumberInvalid10Digits() {
        String number = "3106930664";
        String expectedOutput = "[phone number: INVALID]";
        assertEquals(expectedOutput, PhoneNumberInterpreter.validatePhoneNumber(number));
    }

}
