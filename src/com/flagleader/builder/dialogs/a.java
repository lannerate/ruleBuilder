package com.flagleader.builder.dialogs;

import com.flagleader.a.a.r;
import java.io.File;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class a extends SelectionAdapter
{
  a(AboutLicenseDialog paramAboutLicenseDialog)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    s locals = new s(r.a(new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "cpuid.dll")));
    locals.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a
 * JD-Core Version:    0.6.0
 */