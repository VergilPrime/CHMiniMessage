package com.vergilprime.chminimessage;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.MSVersion;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.CRE.CREThrowable;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import com.laytonsmith.core.natives.interfaces.Mixed;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

public class FunctionGroup{
	public static String docs() {
		return "There's one function and it turns MiniMessage syntax into json for tellraw and similar other function.";
	}

	@api
	public static class minimessage_to_json extends AbstractFunction {

		@Override
		public Class<? extends CREThrowable>[] thrown() {
			return new Class[0];
		}

		@Override
		public boolean isRestricted() {
			return false;
		}

		@Override
		public Boolean runAsync() {
			return null;
		}

		@Override
		public Mixed exec(Target t, Environment environment, Mixed... args) throws ConfigRuntimeException {
			String input = args[0].val();
			Component parsedComponent = CHMiniMessage.miniMessage.deserialize(input);
			String deserialized_string = GsonComponentSerializer.gson().serialize(parsedComponent);
			return new CString(deserialized_string,t);
		}

		@Override
		public Version since() {
			return MSVersion.V3_3_4;
		}

		@Override
		public String getName() {
			return "minimessage_to_json";
		}

		@Override
		public Integer[] numArgs() {
			return new Integer[]{1};
		}

		@Override
		public String docs() {
			return "string {message} Converts minimessage to json.";
		}
	}

}
