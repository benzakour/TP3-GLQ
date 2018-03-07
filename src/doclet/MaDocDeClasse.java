// Mettre tools.jar dans le classpath du projet :
//build path > add external archive : /usr/lib/jvm/java-8-oracle/lib/tools.jar
package doclet;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ProgramElementDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.Tag;

public class MaDocDeClasse extends Doclet {

	/**
	 * <p>
	 * La mÃ©thode start() est appelÃ©e automatiquement par l'outil javadoc.
	 * Exemple d'utilisation de la classe : javadoc -classpath -doclet
	 * madoclet.MaDocDeClasse
	 * 
	 * @param root
	 *            la rootDoc.
	 * @return true si tout s'est bien passé.
	 */
	public static boolean start(RootDoc root) {
		ClassDoc[] classes = root.classes();
		FieldDoc[] champs;
		ConstructorDoc[] constructeurs;
		MethodDoc[] methodes;
		ClassDoc[] interfaces;
		Tag[] tags;
		String superClassName;

		for (int i = 0; i < classes.length; ++i) {
			System.out.println();
			if (classes[i].isClass())
				System.out.print("*** classe ");
			else
				System.out.print("*** interface ");
			System.out.println(classes[i].qualifiedName());
			if (classes[i].isClass()) {
				superClassName = classes[i].superclass().qualifiedName();
				if (!superClassName.equals("java.lang.Object")) {
					System.out.println("          extends " + superClassName);
				}
			}
			interfaces = classes[i].interfaces();
			for (int j = 0; j < interfaces.length; j++) {
				System.out.println("           implements " + interfaces[j].qualifiedName());
			}

			tags = classes[i].tags();
			if ((tags.length != 0) || (!classes[i].commentText().equals(""))) {
				System.out.println("/**");
				System.out.println(classes[i].commentText());
				for (int j = 0; j < tags.length; j++) {
					System.out.println(" * " + tags[j]);
				}
				System.out.println("*/");
			}

			champs = classes[i].fields();
			for (int j = 0; j < champs.length; ++j) {
				System.out.print("     ");
				if (champs[j].isStatic())
					System.out.print("*");
				System.out.print(afficheVisibilite(champs[j]) + " " + champs[j].type() + " " + champs[j].name());
				if (champs[j].isStatic())
					System.out.print("*");
				System.out.println();
			}

			constructeurs = classes[i].constructors();
			for (int j = 0; j < constructeurs.length; ++j) {
				System.out.print("     ");
				System.out.print(afficheVisibilite(constructeurs[j]) + " " + constructeurs[j].name());
				afficheParametres(constructeurs[j]);
				System.out.println();
			}

			methodes = classes[i].methods();
			for (int j = 0; j < methodes.length; ++j) {
				System.out.print("     ");
				if (methodes[j].isStatic())
					System.out.print("*");
				System.out.print(
						afficheVisibilite(methodes[j]) + " " + methodes[j].returnType() + " " + methodes[j].name());
				afficheParametres(methodes[j]);
				if (methodes[j].isStatic())
					System.out.print("*");
				System.out.println();
			}
		}
		return true;
	}

	public static void afficheParametres(ExecutableMemberDoc element) {
		Parameter[] argv = element.parameters();
		Parameter p;
		System.out.print("(");
		for (int k = 0; k < argv.length; k++) {
			p = argv[k];
			if (k == 0)
				System.out.print(p.type() + " " + p.name());
			else
				System.out.print("," + p.type() + " " + p.name());
		}
		System.out.print(")");
	}

	public static String afficheVisibilite(ProgramElementDoc element) {
		if (element.isPublic())
			return "+";
		if (element.isProtected())
			return "#";
		if (element.isPrivate())
			return "-";
		return "";

	}

}
