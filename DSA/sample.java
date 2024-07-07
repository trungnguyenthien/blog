ArrayList < Integer > list = new ArrayList < > ();

// Thêm một số phần tử vào ArrayList
for (int i = 0; i < 10; i++) {
  list.add(i);
}

// In ra kích thước của ArrayList
System.out.println("Size: " + list.size());

// Lấy capacity bằng reflection
Field field = ArrayList.class.getDeclaredField("elementData");
field.setAccessible(true);
Object[] elementData = (Object[]) field.get(list);
System.out.println("Capacity: " + elementData.length);