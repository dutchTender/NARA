package gov.nara.um.util;

import java.util.Collection;
import java.util.Set;

import gov.nara.um.persistence.model.Privilege;
import gov.nara.um.persistence.model.Role;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

public final class UmConvertionUtil {

    private UmConvertionUtil() {
        throw new AssertionError();
    }

    // API



    public static Collection<String> convertPrivilegesToPrivilegeNames(final Collection<Privilege> privileges) {
        final Function<Object, String> toStringFunction = Functions.toStringFunction();
        return Collections2.transform(privileges, toStringFunction);
    }



}
