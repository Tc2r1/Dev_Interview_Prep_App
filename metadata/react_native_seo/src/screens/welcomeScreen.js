/* eslint-disable react-hooks/rules-of-hooks */
import React, {useState} from 'react';
import {
  View,
  Text,
  StyleSheet,
  Image,
  TextInput,
  ToastAndroid,
} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import {Button} from 'react-native-elements';
import {useStateValue} from '../stateProvider';

const welcomeScreen = ({navigation}) => {
  const [{}, dispatch] = useStateValue();
  const [Name, setName] = useState('');
  return (
    <View style={styles.welcomeScreen}>
      <Image style={styles.logo} source={require('../../assets/logo.png')} />
      <Text style={styles.welcomeText}>Welcome To Quiz App</Text>
      <Text style={styles.welcomeText}>Enter your name to Proceed...</Text>
      <TextInput
        style={styles.inputBox}
        value={Name}
        onChangeText={setName}
        placeholder="Enter Your Name"
        placeholderTextColor="black"
      />
      <Button
        icon={<Icon name="arrow-circle-right" size={70} color="blue" />}
        type="clear"
        onPress={() => {
          if (Name === '') {
            ToastAndroid.show(
              'Enter your name to proceed...',
              ToastAndroid.CENTER,
            );
          } else {
            dispatch({
              type: 'SET_USER',
              user: Name,
            });
            navigation.navigate('QuestionScreen');
          }
        }}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  welcomeScreen: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  logo: {
    height: 200,
    width: 200,
  },
  welcomeText: {
    fontSize: 25,
    marginTop: 15,
    textAlign: 'center',
  },
  inputBox: {
    width: '85%',
    height: 40,
    margin: 12,
    borderBottomWidth: 3,
    borderBottomColor: '#3700B3',
    marginTop: 60,
    color: 'black',
  },
});
export default welcomeScreen;
