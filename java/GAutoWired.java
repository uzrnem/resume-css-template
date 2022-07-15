interface Mobile {
	
}

//@Componenet for default name will be nokia... @Component("StrongNokia")
class GNokia implements Mobile {
	
}
//@primary
//@Componenet("HangySamsung")
class GSamsung implements Mobile {
	
}
public class GAutoWired {

	//@AutoWired
	//@Qualifier("nokia")
	Mobile g;
}
