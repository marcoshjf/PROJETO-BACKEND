import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import login from '../componentes/login'


const Stack = createStackNavigator();

export default function Nav(){
    return(
     <NavigationContainer>
        <Stack.Navigator>
            <Stack.Screen name='login' component={login}/>
        </Stack.Navigator>
      </NavigationContainer>
    )
}